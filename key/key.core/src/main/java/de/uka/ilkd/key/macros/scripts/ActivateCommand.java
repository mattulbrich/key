This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.macros.scripts;

import de.uka.ilkd.key.control.AbstractUserInterfaceControl;
import de.uka.ilkd.key.proof.Goal;

/**
 * Command for re-activating the first open (not necessarily enabled)
 * {@link Goal} after a "leave" command. Can be useful for complicated proofs
 * where "tryclose" should not apply on certain branches temporarily, but where
 * one still wants to finish the proof.
 *
 * @author Dominic Steinhoefel
 */
public class ActivateCommand extends NoArgumentCommand {
    @Override
    public String getName() {
        return "activate";
    }

    @Override
    public void execute(AbstractUserInterfaceControl uiControl, Void args,
            EngineState state) throws ScriptException, InterruptedException {
        Goal goal = state.getFirstOpenGoal(false);
        goal.setEnabled(true);
    }

}
