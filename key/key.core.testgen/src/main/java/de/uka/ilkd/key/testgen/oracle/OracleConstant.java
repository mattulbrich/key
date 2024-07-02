This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.testgen.oracle;

import de.uka.ilkd.key.logic.sort.Sort;

public class OracleConstant implements OracleTerm {

    private String value;

    private Sort sort;

    public static final OracleConstant TRUE = new OracleConstant("true", Sort.FORMULA);
    public static final OracleConstant FALSE = new OracleConstant("false", Sort.FORMULA);

    public OracleConstant(String value, Sort sort) {
        this.value = value;
        this.sort = sort;
    }

    public String getValue() {
        return value;
    }

    public Sort getSort() {
        return sort;
    }

    public void setSort(Sort sort) {
        this.sort = sort;
    }

    public String toString() {
        return value;
    }


}
