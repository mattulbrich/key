This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.testgen.oracle;

import java.util.HashMap;
import java.util.Map;

public class OracleUnaryTerm implements OracleTerm {



    public enum Op {
        Neg, Minus
    };

    public static String OP_NEG = "!";
    public static String OP_MINUS = "-";
    private static Map<Op, String> op2String;

    static {
        op2String = new HashMap<OracleUnaryTerm.Op, String>();
        op2String.put(Op.Neg, OP_NEG);
        op2String.put(Op.Minus, OP_MINUS);
    }


    private OracleTerm sub;
    private Op op;

    public OracleUnaryTerm(OracleTerm sub, Op op) {
        this.sub = sub;
        this.op = op;
    }



    public Op getOp() {
        return op;
    }



    public OracleTerm getSub() {
        return sub;
    }

    public String toString() {
        return op2String.get(op) + sub.toString();
    }
}
