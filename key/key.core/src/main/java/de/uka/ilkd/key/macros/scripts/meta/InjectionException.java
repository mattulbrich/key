This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.macros.scripts.meta;

/**
 *
 *
 * @author Alexander Weigl
 * @version 1 (02.05.17)
 */
public class InjectionException extends Exception {

    private static final long serialVersionUID = 4922701573932568352L;
    private final ProofScriptArgument<?> argument;

    /**
     * An injection reflection exception with no cause (to display).
     *
     * @param message the respective String message to be passed.
     * @param argument the proof script argument.
     */
    public InjectionException(String message,
            ProofScriptArgument<?> argument) {
        super(message);
        this.argument = argument;
    }

    /**
     * An injection exception with a cause to be displayed.
     *
     * @param message the respective String message to be passed.
     * @param cause the cause of the exception.
     * @param argument the proof script argument.
     */
    public InjectionException(String message, Throwable cause,
            ProofScriptArgument<?> argument) {
        super(message, cause);
        this.argument = argument;
    }

    /**
     * Get the (proof script) argument of this injection exception.
     *
     * @return the proof script argument.
     */
    public ProofScriptArgument<?> getArgument() {
        return argument;
    }
}
