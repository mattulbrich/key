This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.smt.communication;

import java.io.IOException;
import javax.annotation.Nonnull;

import de.uka.ilkd.key.smt.ModelExtractor;
import de.uka.ilkd.key.smt.SMTSolverResult;
import de.uka.ilkd.key.smt.st.SolverType;

/**
 * The socket for generating counterexamples.
 *
 * @author Wolfram Pfeifer (overhaul)
 */
public class Z3CESocket extends AbstractSolverSocket {
    /**
     * Creates a new Z3CESocket. Should not be called directly, better use the static factory method
     * {@link AbstractSolverSocket#createSocket(SolverType, ModelExtractor)}.
     *
     * @param name the name of the solver
     * @param query the ModelExtractor for CE generation
     */
    public Z3CESocket(String name, ModelExtractor query) {
        super(name, query);
    }

    @Override
    public void messageIncoming(@Nonnull Pipe pipe, @Nonnull String msg) throws IOException {
        SolverCommunication sc = pipe.getSolverCommunication();

        if (msg.startsWith("(error")) {
            sc.addMessage(msg, SolverCommunication.MessageType.ERROR);
            if (msg.contains("WARNING:")) {
                return;
            }
            throw new IOException("Error while executing Z3: " + msg);
        }
        // These two messages are only used to steer the interaction with the solver and are thus
        // currently filtered out to avoid cluttering up the output.
        if (!msg.equals("success") && !msg.equals("endmodel")) {
            sc.addMessage(msg, SolverCommunication.MessageType.OUTPUT);
        }

        switch (sc.getState()) {
        case WAIT_FOR_RESULT:
            if (msg.equals("unsat")) {
                sc.setFinalResult(SMTSolverResult.createValidResult(getName()));
                pipe.sendMessage("(exit)");
                sc.setState(WAIT_FOR_DETAILS);
            }
            if (msg.equals("sat")) {
                sc.setFinalResult(SMTSolverResult.createInvalidResult(getName()));
                pipe.sendMessage("(get-model)");
                pipe.sendMessage("(echo \"endmodel\")");
                sc.setState(WAIT_FOR_MODEL);
            }
            if (msg.equals("unknown")) {
                sc.setFinalResult(SMTSolverResult.createUnknownResult(getName()));
                sc.setState(WAIT_FOR_DETAILS);
                pipe.sendMessage("(exit)");
            }

            break;

        case WAIT_FOR_DETAILS:
            // Currently we rely on the solver to terminate after receiving "(exit)". If this does
            // not work in future, it may be that we have to forcibly close the pipe.
            break;

        case WAIT_FOR_QUERY:
            if (!msg.equals("success")) {
                getQuery().messageIncoming(pipe, msg);
            }
            break;

        case WAIT_FOR_MODEL:
            if (msg.equals("endmodel")) {
                if (getQuery() != null && getQuery().getState() == ModelExtractor.DEFAULT) {
                    getQuery().getModel().setEmpty(false);
                    getQuery().start(pipe);
                    sc.setState(WAIT_FOR_QUERY);
                } else {
                    pipe.sendMessage("(exit)\n");
                    sc.setState(WAIT_FOR_DETAILS);
                }
            }
            break;
        default:
            throw new IllegalStateException("Unexpected value: " + sc.getState());
        }
    }
}
