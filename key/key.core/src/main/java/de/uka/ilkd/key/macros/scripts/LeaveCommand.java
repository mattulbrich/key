This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.macros.scripts;

import java.util.logging.Logger;

import de.uka.ilkd.key.control.AbstractUserInterfaceControl;
import de.uka.ilkd.key.proof.Goal;

public class LeaveCommand extends NoArgumentCommand {
    private static Logger log = Logger.getLogger(ProofScriptCommand.class.getName());


    @Override
    public String getName() {
        return "leave";
    }

    @Override
    public void execute(AbstractUserInterfaceControl uiControl,
            Void args, EngineState state) throws ScriptException, InterruptedException {
        Goal goal = state.getFirstOpenAutomaticGoal();
        log.info("Deactivating " + goal.node().serialNr());
        goal.setEnabled(false);
    }

}
