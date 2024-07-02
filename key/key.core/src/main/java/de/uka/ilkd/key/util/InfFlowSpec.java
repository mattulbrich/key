This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.util;

import java.util.function.UnaryOperator;

import de.uka.ilkd.key.logic.Term;

import org.key_project.util.collection.ImmutableList;
import org.key_project.util.collection.ImmutableSLList;


/**
 *
 * @author christoph
 */
public class InfFlowSpec {
    public static final InfFlowSpec EMPTY_INF_FLOW_SPEC = new InfFlowSpec();

    public final ImmutableList<Term> preExpressions;

    public final ImmutableList<Term> postExpressions;

    public final ImmutableList<Term> newObjects;


    public InfFlowSpec(final ImmutableList<Term> preExpressions,
            final ImmutableList<Term> postExpressions,
            final ImmutableList<Term> newObjects) {
        this.preExpressions = preExpressions;
        this.postExpressions = postExpressions;
        this.newObjects = newObjects;
    }

    /**
     * Applies a unary operator to every list of terms in this InfFlow specification element.
     *
     * @param op the operator to apply.
     * @return this InfFlow specification element with the operator applied.
     */
    public InfFlowSpec map(UnaryOperator<Term> op) {
        return new InfFlowSpec(
            preExpressions.stream().map(op).collect(ImmutableList.collector()),
            postExpressions.stream().map(op).collect(ImmutableList.collector()),
            newObjects.stream().map(op).collect(ImmutableList.collector()));
    }

    private InfFlowSpec() {
        this.preExpressions = ImmutableSLList.<Term>nil();
        this.postExpressions = ImmutableSLList.<Term>nil();
        this.newObjects = ImmutableSLList.<Term>nil();
    }
}
