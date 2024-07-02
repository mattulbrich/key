This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.testgen.oracle;

public class OracleBinTerm implements OracleTerm {

    private String op;

    private OracleTerm left;

    private OracleTerm right;

    public OracleBinTerm(String op, OracleTerm left,
            OracleTerm right) {
        super();
        this.op = op;
        this.left = left;
        this.right = right;
    }

    public String getOp() {
        return op;
    }

    public OracleTerm getLeft() {
        return left;
    }

    public OracleTerm getRight() {
        return right;
    }

    public String toString() {
        return "(" + left.toString() + " " + op + " " + right.toString() + ")";
    }



}
