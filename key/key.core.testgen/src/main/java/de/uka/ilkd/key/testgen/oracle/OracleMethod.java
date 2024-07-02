This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.testgen.oracle;

import java.util.List;

import de.uka.ilkd.key.logic.sort.Sort;
import de.uka.ilkd.key.testgen.TestCaseGenerator;

public class OracleMethod {

    private final String methodName;

    private final List<OracleVariable> args;

    private final String body;

    private Sort returnType;

    public OracleMethod(String methodName, List<OracleVariable> args,
            String body) {
        super();
        this.methodName = methodName;
        this.args = args;
        this.body = body;
    }

    public OracleMethod(String methodName, List<OracleVariable> args,
            String body, Sort sort) {
        super();
        this.methodName = methodName;
        this.args = args;
        this.body = body;
        this.returnType = sort;
    }

    public String getMethodName() {
        return methodName;
    }

    public List<OracleVariable> getArgs() {
        return args;
    }

    public String getBody() {
        return body;
    }

    @Override
    public String toString() {
        String tab = TestCaseGenerator.TAB;
        StringBuilder argString = new StringBuilder();

        for (OracleVariable var : args) {
            argString.append(var.getSort().name()).append(" ").append(var.getName()).append(",");
        }
        if (!args.isEmpty()) {
            argString = new StringBuilder(argString.substring(0, argString.length() - 1));
        }

        String retType = "boolean";
        if (returnType != null) {
            retType = returnType.name().toString();
        }
        return tab + "public " + retType + " " + methodName + "(" + argString + "){\n"
            + tab + tab + body + "\n"
            + tab + "}";

    }
}
