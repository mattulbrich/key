This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.testgen;

import java.io.Writer;

import de.uka.ilkd.key.java.PrettyPrinter;
import de.uka.ilkd.key.java.statement.MethodBodyStatement;
import de.uka.ilkd.key.logic.op.IProgramVariable;
import de.uka.ilkd.key.rule.inst.SVInstantiations;

public class CustomPrettyPrinter extends PrettyPrinter {
    public CustomPrettyPrinter(Writer o) {
        super(o);

    }

    public CustomPrettyPrinter(Writer o, SVInstantiations svi) {
        super(o, svi);

    }

    public CustomPrettyPrinter(Writer o, boolean noLinefeed) {
        super(o, noLinefeed);

    }

    public CustomPrettyPrinter(Writer o, boolean noLinefeed,
            SVInstantiations svi) {
        super(o, noLinefeed, svi);

    }

    public void printMethodBodyStatement(MethodBodyStatement x)
            throws java.io.IOException {

        boolean wasNoLinefeed = noLinefeed;
        noLinefeed = false;

        printHeader(x);
        writeInternalIndentation(x);
        markStart(0, x);

        IProgramVariable pvar = x.getResultVariable();
        if (pvar != null) {
            writeElement(pvar);
            write("=");
        }

        printMethodReference(x.getMethodReference(), false);
        // // CHG:
        // write("@");
        // final TypeReference tr = x.getBodySourceAsTypeReference();
        // if (tr instanceof SchemaTypeReference) {
        // printSchemaTypeReference((SchemaTypeReference) tr);
        // } else if (tr instanceof SchemaVariable) {
        // printSchemaVariable((SchemaVariable) tr);
        // } else {
        // printTypeReference(tr);
        // }
        write(";");
        markEnd(0, x);
        printFooter(x);

        noLinefeed = wasNoLinefeed;
    }
}
