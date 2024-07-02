This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.nparser.varexp;

import de.uka.ilkd.key.java.abstraction.KeYJavaType;
import de.uka.ilkd.key.logic.Term;
import de.uka.ilkd.key.logic.op.ParsableVariable;
import de.uka.ilkd.key.logic.sort.Sort;
import de.uka.ilkd.key.rule.conditions.TypeResolver;

/**
 * Argument types for {@link TacletBuilderCommand}s.
 *
 * @author Alexander Weigl
 * @version 1 (12/9/19)
 * @see TacletBuilderCommand
 */
public enum ArgumentType {
    TYPE_RESOLVER(TypeResolver.class),
    SORT(Sort.class),
    TERM(Term.class),
    JAVA_TYPE(KeYJavaType.class),
    VARIABLE(ParsableVariable.class),
    STRING(String.class);

    public final Class<?> clazz;

    ArgumentType(Class<?> clazz) {
        this.clazz = clazz;
    }
}
