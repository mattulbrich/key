This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.smt.newsmt2;

import de.uka.ilkd.key.smt.newsmt2.SMTHandlerProperty.BooleanProperty;
import de.uka.ilkd.key.smt.newsmt2.SMTHandlerProperty.EnumProperty;
import de.uka.ilkd.key.smt.newsmt2.SMTHandlerProperty.IntegerProperty;
import de.uka.ilkd.key.smt.newsmt2.SMTHandlerProperty.StringProperty;

/**
 * Visitor pattern for {@link SMTHandlerProperty} objects.
 *
 * @param <A> argument type
 * @param <R> return type
 */
public interface SMTHandlerPropertyVisitor<A, R> {
    R visit(EnumProperty<?> enumProp, A arg);

    R visit(IntegerProperty integerProp, A arg);

    R visit(BooleanProperty booleanProp, A arg);

    R visit(StringProperty stringProp, A arg);
}
