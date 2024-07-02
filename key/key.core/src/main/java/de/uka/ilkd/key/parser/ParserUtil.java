This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.parser;

import java.net.MalformedURLException;
import java.net.URL;

import de.uka.ilkd.key.java.reference.*;
import de.uka.ilkd.key.parser.proofjava.Token;
import de.uka.ilkd.key.util.parsing.LocatableException;

import recoder.java.Expression;
import recoder.java.reference.UncollatedReferenceQualifier;

/**
 * @author Alexander Weigl
 * @version 1 (6/21/21)
 */
public final class ParserUtil {
    /**
     * Throws an exception if the given expression is invalid in a {@code \singleton} constructor.
     * The given token is used for positional information.
     */
    public static void checkValidSingletonReference(Expression expr, Token tok) {
        // weigl: I hope I catch them all.
        if (expr instanceof VariableReference
                || expr instanceof ThisReference
                || expr instanceof ArrayReference
                || expr instanceof ArrayLengthReference
                || expr instanceof UncollatedReferenceQualifier
                || expr instanceof SuperReference) {
            return;
        }
        Location loc = new Location((URL) null, tok.beginLine, tok.beginColumn);
        throw new LocatableException("Given non-reference as parameter for \\singleton", loc);
    }
}
