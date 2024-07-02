This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.smt.st;

import javax.annotation.Nonnull;

import de.uka.ilkd.key.java.Services;
import de.uka.ilkd.key.smt.*;
import de.uka.ilkd.key.smt.communication.AbstractSolverSocket;
import de.uka.ilkd.key.smt.communication.Z3Socket;

/**
 * @author Alexander Weigl
 * @version 1 (9/29/21)
 */
public class Z3SolverType extends AbstractSolverType {
    @Override
    public String getDefaultSolverCommand() {
        return "z3";
    }

    @Override
    public String getDefaultSolverParameters() {
        return "-in -smt2";
    }

    @Override
    public SMTSolver createSolver(SMTProblem problem,
            SolverListener listener, Services services) {
        return new SMTSolverImplementation(problem, listener,
            services, this);
    }

    @Override
    public String getName() {
        return "Z3 (Legacy Translation)";
    }

    @Override
    public String getVersionParameter() {
        return "-version";
    }

    @Override
    public String getRawVersion() {
        final String tmp = super.getRawVersion();
        if (tmp == null) {
            return null;
        }
        return tmp.substring(tmp.indexOf("version"));
    }

    @Override
    public @Nonnull AbstractSolverSocket getSocket(ModelExtractor query) {
        return new Z3Socket(getName(), query);
    }

    @Override
    public String[] getSupportedVersions() {
        return new String[] { "version 3.2", "version 4.1", "version 4.3.0", "version 4.3.1" };
    }

    @Override
    public String[] getDelimiters() {
        return new String[] { "\n", "\r" };
    }

    @Override
    public boolean supportsIfThenElse() {
        return true;
    }

    @Override
    public SMTTranslator createTranslator(Services services) {
        return new SmtLib2Translator(services,
            new AbstractSMTTranslator.Configuration(false, false));
    }


    @Override
    public String getInfo() {
        return "";
    }
}
