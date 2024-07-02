This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.smt;

public class SMTTranslationException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = -2230789489767950432L;

    public SMTTranslationException() {
    }

    public SMTTranslationException(String message) {
        super(message);
    }

    public SMTTranslationException(Throwable cause) {
        super(cause);
    }

    public SMTTranslationException(String message, Throwable cause) {
        super(message, cause);
    }

    public SMTTranslationException(String message, Throwable cause,
            boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
