This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.macros.scripts;

import java.util.Map;

import de.uka.ilkd.key.macros.scripts.meta.Option;

/**
 * Halts the script if some condition is not met.
 *
 * @author lanzinger
 *
 * @deprecated  The name of this command is like to change since "assert" should
 * be used for a more general purpose. You may find that this is called
 * "assertOpenGoals".
 */
public class AssertCommand extends AbstractCommand<AssertCommand.Parameters> {

    /**
     * Instantiates a new assert command.
     */
    public AssertCommand() {
        super(Parameters.class);
    }

    @Override
    public Parameters evaluateArguments(EngineState state,
            Map<String, String> arguments) throws Exception {
        return state.getValueInjector().inject(this, new Parameters(),
            arguments);
    }

    @Override
    public void execute(Parameters args)
            throws ScriptException, InterruptedException {
        if (args.goals == null) {
            throw new ScriptException("No parameter specified!");
        }

        if (state.getProof().openEnabledGoals().size() != args.goals.intValue()) {
            throw new ScriptException(
                "Assertion failed: number of open goals is " +
                    state.getProof().openGoals().size() +
                    ", but should be " +
                    args.goals.intValue());
        }
    }

    @Override
    public String getName() {
        return "assert";
    }

    /**
     * The Assigned parameters (currently only the passed goals).
     */
    public static class Parameters {
        /**
         * The number of open and enabled goals.
         */
        @Option("goals")
        public Integer goals;
    }
}
