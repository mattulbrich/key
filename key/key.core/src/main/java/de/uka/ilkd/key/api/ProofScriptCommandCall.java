This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.api;

import de.uka.ilkd.key.macros.scripts.ProofScriptCommand;

/**
 * @param <T>
 * @author Alexander Weigl
 */
public class ProofScriptCommandCall<T> {
    T parameter;
    ProofScriptCommand<T> command;

    public ProofScriptCommandCall(ProofScriptCommand<T> command, T arguments) {
        parameter = arguments;
        this.command = command;
    }
}
