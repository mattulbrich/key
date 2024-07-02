This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.speclang.njml;

import java.util.Map;
import javax.annotation.Nullable;

import de.uka.ilkd.key.java.Services;
import de.uka.ilkd.key.java.abstraction.KeYJavaType;
import de.uka.ilkd.key.java.abstraction.Type;
import de.uka.ilkd.key.logic.Term;
import de.uka.ilkd.key.logic.op.Operator;
import de.uka.ilkd.key.logic.sort.Sort;
import de.uka.ilkd.key.speclang.njml.OverloadedOperatorHandler.JMLOperator;
import de.uka.ilkd.key.speclang.njml.OverloadedOperatorHandler.JMLOperatorHandler;
import de.uka.ilkd.key.speclang.translation.SLExpression;
import de.uka.ilkd.key.speclang.translation.SLTranslationException;

public abstract class LDTHandler implements JMLOperatorHandler {

    protected final Services services;

    protected LDTHandler(Services services) {
        this.services = services;
    }

    @Nullable
    public SLExpression build(JMLOperator op, SLExpression left, SLExpression right)
            throws SLTranslationException {
        if (OverloadedOperatorHandler.UNARY_OPERATORS.contains(op)) {
            return buildUnary(op, left);
        }

        KeYJavaType promotedType =
            services.getTypeConverter().getPromotedType(left.getType(), right.getType());
        Map<JMLOperator, Operator> opMap = getOperatorMap(promotedType.getJavaType());
        if (opMap == null) {
            // we are not responsible for the promoted promotedType
            return null;
        }
        Operator jop = opMap.get(op);
        if (jop == null) {
            // TODO should that perhaps be an exception?
            return null;
        }

        Term a = promote(left.getTerm(), promotedType);
        Term b = promote(right.getTerm(), promotedType);
        Term resultTerm = services.getTermFactory().createTerm(jop, a, b);
        if (OverloadedOperatorHandler.PREDICATES.contains(op)) {
            // should be "formula", but apparently there is no KJT for that.
            return new SLExpression(resultTerm);
        } else {
            return new SLExpression(resultTerm, promotedType);
        }
    }

    protected abstract Map<JMLOperator, Operator> getOperatorMap(Type promotedType);

    private SLExpression buildUnary(JMLOperator op, SLExpression left) {
        KeYJavaType type = left.getType();
        Map<JMLOperator, Operator> opMap = getOperatorMap(type.getJavaType());
        if (opMap == null) {
            // we are not responsible for the type
            return null;
        }
        Operator jop = opMap.get(op);
        if (jop == null) {
            // TODO should that perhaps be an exception?
            return null;
        }

        Term resultTerm = services.getTermFactory().createTerm(jop, left.getTerm());
        SLExpression result = new SLExpression(resultTerm, type);
        return result;
    }

    private Term promote(Term term, KeYJavaType resultType) {
        Sort targetSort = resultType.getSort();
        if (term.sort() != targetSort) {
            return services.getTermBuilder().cast(targetSort, term);
        } else {
            return term;
        }
    }
}
