This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.speclang.njml;

import java.util.EnumMap;
import java.util.IdentityHashMap;
import java.util.Map;
import javax.annotation.Nullable;

import de.uka.ilkd.key.java.Services;
import de.uka.ilkd.key.java.abstraction.KeYJavaType;
import de.uka.ilkd.key.java.abstraction.PrimitiveType;
import de.uka.ilkd.key.java.abstraction.Type;
import de.uka.ilkd.key.ldt.FloatLDT;
import de.uka.ilkd.key.ldt.IntegerLDT;
import de.uka.ilkd.key.logic.Term;
import de.uka.ilkd.key.logic.op.Operator;
import de.uka.ilkd.key.logic.sort.Sort;
import de.uka.ilkd.key.speclang.njml.OverloadedOperatorHandler.JMLOperator;
import de.uka.ilkd.key.speclang.njml.OverloadedOperatorHandler.JMLOperatorHandler;
import de.uka.ilkd.key.speclang.translation.SLExceptionFactory;
import de.uka.ilkd.key.speclang.translation.SLExpression;
import de.uka.ilkd.key.speclang.translation.SLTranslationException;

import static de.uka.ilkd.key.speclang.njml.OverloadedOperatorHandler.JMLOperator.ADD;
import static de.uka.ilkd.key.speclang.njml.OverloadedOperatorHandler.JMLOperator.BITWISE_AND;
import static de.uka.ilkd.key.speclang.njml.OverloadedOperatorHandler.JMLOperator.BITWISE_NEGATE;
import static de.uka.ilkd.key.speclang.njml.OverloadedOperatorHandler.JMLOperator.BITWISE_OR;
import static de.uka.ilkd.key.speclang.njml.OverloadedOperatorHandler.JMLOperator.BITWISE_XOR;
import static de.uka.ilkd.key.speclang.njml.OverloadedOperatorHandler.JMLOperator.DIVISION;
import static de.uka.ilkd.key.speclang.njml.OverloadedOperatorHandler.JMLOperator.GT;
import static de.uka.ilkd.key.speclang.njml.OverloadedOperatorHandler.JMLOperator.GTE;
import static de.uka.ilkd.key.speclang.njml.OverloadedOperatorHandler.JMLOperator.LT;
import static de.uka.ilkd.key.speclang.njml.OverloadedOperatorHandler.JMLOperator.LTE;
import static de.uka.ilkd.key.speclang.njml.OverloadedOperatorHandler.JMLOperator.MODULO;
import static de.uka.ilkd.key.speclang.njml.OverloadedOperatorHandler.JMLOperator.MULT;
import static de.uka.ilkd.key.speclang.njml.OverloadedOperatorHandler.JMLOperator.SHIFT_LEFT;
import static de.uka.ilkd.key.speclang.njml.OverloadedOperatorHandler.JMLOperator.SHIFT_RIGHT;
import static de.uka.ilkd.key.speclang.njml.OverloadedOperatorHandler.JMLOperator.SUBTRACT;
import static de.uka.ilkd.key.speclang.njml.OverloadedOperatorHandler.JMLOperator.UNARY_MINUS;
import static de.uka.ilkd.key.speclang.njml.OverloadedOperatorHandler.JMLOperator.UNSIGNED_SHIFT_RIGHT;

public class FloatHandler extends LDTHandler {

    private final Map<JMLOperator, Operator> opMap =
        new EnumMap<>(JMLOperator.class);

    public FloatHandler(Services services) {
        super(services);

        FloatLDT floatLDT = services.getTypeConverter().getFloatLDT();

        opMap.put(ADD, floatLDT.getAdd());
        opMap.put(SUBTRACT, floatLDT.getSub());
        opMap.put(MULT, floatLDT.getMul());
        opMap.put(DIVISION, floatLDT.getDiv());
        opMap.put(MODULO, floatLDT.getJavaMod());
        opMap.put(UNARY_MINUS, floatLDT.getNeg());
        opMap.put(GT, floatLDT.getGreaterThan());
        opMap.put(LT, floatLDT.getLessThan());
        opMap.put(GTE, floatLDT.getGreaterOrEquals());
        opMap.put(LTE, floatLDT.getLessOrEquals());
    }

    @Override
    protected Map<JMLOperator, Operator> getOperatorMap(Type promotedType) {
        if (promotedType == PrimitiveType.JAVA_FLOAT) {
            return opMap;
        } else {
            return null;
        }
    }

}
