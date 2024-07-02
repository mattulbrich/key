This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.nparser.builder;

import javax.annotation.Nullable;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

/**
 * @author Alexander Weigl
 * @version 1 (12/9/19)
 */
public final class BuilderHelpers {
    public static String getPosition(@Nullable ParserRuleContext node) {
        if (node == null)
            return " pos n/a";
        return getPosition(node.start);
    }

    public static String getPosition(@Nullable Token t) {
        return t == null
                ? " pos n/a"
                : String.format(" %s:%d#%d",
                    t.getInputStream().getSourceName(), t.getLine(), t.getCharPositionInLine());
    }

}
