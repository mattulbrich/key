This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.util;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

/**
 *
 */
public class Position {
    private final String source;
    private final int line;
    private final int charInLine;
    private final int startOffset;
    private final int length;

    public Position(String source, int line, int charInLine, int startOffset, int length) {
        this.source = source;
        this.line = line;
        this.charInLine = charInLine;
        this.startOffset = startOffset;
        this.length = length;
    }

    public static Position make(ParserRuleContext ctx) {
        return make(ctx.start);
    }

    public static Position make(Token ctx) {
        return new Position(ctx.getTokenSource().getSourceName(), ctx.getLine(),
            ctx.getCharPositionInLine(), ctx.getStartIndex(),
            ctx.getStopIndex() - ctx.getStartIndex()/* maybe +1 */);
    }


    public String getSource() {
        return source;
    }

    public int getLine() {
        return line;
    }

    public int getCharInLine() {
        return charInLine;
    }

    public int getStartOffset() {
        return startOffset;
    }

    public int getLength() {
        return length;
    }
}
