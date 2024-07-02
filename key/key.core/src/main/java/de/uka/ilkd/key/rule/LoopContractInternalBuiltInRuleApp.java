This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.rule;

import java.util.List;

import de.uka.ilkd.key.java.statement.JavaStatement;
import de.uka.ilkd.key.logic.PosInOccurrence;
import de.uka.ilkd.key.logic.op.LocationVariable;
import de.uka.ilkd.key.proof.Goal;
import de.uka.ilkd.key.speclang.LoopContract;

import org.key_project.util.collection.ImmutableList;

/**
 * Application of {@link LoopContractInternalRule}.
 *
 * @author lanzinger
 */
public class LoopContractInternalBuiltInRuleApp extends AbstractLoopContractBuiltInRuleApp {

    /**
     *
     * @param rule
     *        the rule being applied.
     * @param occurrence
     *        the position at which the rule is applied.
     */
    public LoopContractInternalBuiltInRuleApp(final BuiltInRule rule,
            final PosInOccurrence occurrence) {
        this(rule, occurrence, null, null, null, null);
    }

    /**
     *
     * @param rule
     *        the rule being applied.
     * @param occurrence
     *        the position at which the rule is applied.
     * @param ifInstantiations
     *        if instantiations.
     * @param statement
     *        the statement which the applied contract belongs to.
     * @param contract
     *        the contract being applied.
     * @param heaps
     *        the heap context.
     */
    public LoopContractInternalBuiltInRuleApp(final BuiltInRule rule,
            final PosInOccurrence occurrence,
            final ImmutableList<PosInOccurrence> ifInstantiations,
            final JavaStatement statement,
            final LoopContract contract,
            final List<LocationVariable> heaps) {
        super(rule, occurrence, ifInstantiations);
        assert rule != null;
        assert rule instanceof LoopContractInternalRule;
        assert occurrence != null;
        setStatement(statement);
        this.contract = contract;
        this.heaps = heaps;
    }

    @Override
    public LoopContractInternalBuiltInRuleApp replacePos(final PosInOccurrence newOccurrence) {
        return new LoopContractInternalBuiltInRuleApp(builtInRule, newOccurrence, ifInsts,
            getStatement(), contract, heaps);
    }

    @Override
    public LoopContractInternalBuiltInRuleApp setIfInsts(
            final ImmutableList<PosInOccurrence> ifInstantiations) {
        setMutable(ifInstantiations);
        return this;
    }

    @Override
    public LoopContractInternalBuiltInRuleApp tryToInstantiate(final Goal goal) {

        return (LoopContractInternalBuiltInRuleApp) super.tryToInstantiate(goal,
            LoopContractInternalRule.INSTANCE);
    }
}
