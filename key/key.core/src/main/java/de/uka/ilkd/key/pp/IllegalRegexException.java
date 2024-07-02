This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.pp;

/**
 * This exception is thrown when a String is expected be a valid
 * regular expression, but is not.
 *
 * @author jschiffl
 */
public class IllegalRegexException extends Exception {

    private static final long serialVersionUID = 1113541L;

    /**
     * constructor
     *
     * @param cause the cause of the exception
     */
    public IllegalRegexException(Throwable cause) {
        super(cause);
    }
}
