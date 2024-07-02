This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.nparser.varexp;

import java.util.List;

import de.uka.ilkd.key.rule.VariableCondition;
import de.uka.ilkd.key.rule.tacletbuilder.TacletBuilder;

/**
 * A specilized {@link TacletBuilderCommand} for handling {@code \varcond}s.
 *
 * @author Alexander Weigl
 * @version 1 (12/10/19)
 */
public interface ConditionBuilder extends TacletBuilderCommand {
    /**
     * Should construct a variable condition for the given arguments and parameters.
     * The arguments are the adhering the type specified in {@link #getArgumentTypes()}.
     * <p>
     * For a varcond {@code \varcond(\abc[p1,p2](a1, a2))} the arguments are a1 and a2,
     * the parameters are p1 and p2. {@code negated} is true if {@code \not} is used.
     */
    VariableCondition build(Object[] arguments, List<String> parameters, boolean negated);

    /**
     * This method will add the contructed {@link VariableCondition} to given {@code tacletBuilder}.
     *
     * @see TacletBuilderCommand#apply(TacletBuilder, Object[], List, boolean)
     */
    @Override
    default void apply(TacletBuilder<?> tacletBuilder, Object[] arguments, List<String> parameters,
            boolean negated) {
        VariableCondition condition = build(arguments, parameters, negated);
        tacletBuilder.addVariableCondition(condition);
    }
}
