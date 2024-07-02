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

public class ExitCommand extends NoArgumentCommand {
    @Override
    public void execute(AbstractUserInterfaceControl uiControl,
            Void args, EngineState stateMap)
            throws ScriptException, InterruptedException {
        throw new InterruptedException(
            "Interruption requested from within script");

    }

    @Override
    public String getName() {
        return "exit";
    }
}
