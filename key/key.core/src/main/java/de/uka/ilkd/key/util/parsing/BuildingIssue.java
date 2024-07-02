This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.util.parsing;

import javax.annotation.Nullable;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.Token;

public class BuildingIssue {
    private final String message;
    private final int lineNumber;
    private final int posInLine;
    private final int startOffset;
    private final int endOffset;
    private final @Nullable Throwable cause;
    private final boolean isWarning;

    public BuildingIssue(String message, @Nullable Throwable cause,
            boolean isWarning,
            int lineNumber, int posInLine, int startOffset, int endOffset) {
        this.message = message;
        this.lineNumber = lineNumber;
        this.posInLine = posInLine;
        this.startOffset = startOffset;
        this.endOffset = endOffset;
        this.cause = cause;
        this.isWarning = isWarning;
    }


    public static BuildingIssue createError(String message,
            @Nullable ParserRuleContext token, @Nullable Throwable cause) {
        return createError(message, token != null ? token.start : null, cause);
    }

    public static BuildingIssue createError(String message, @Nullable Token token,
            @Nullable Throwable cause) {
        if (token != null) {
            int lineNumber = token.getLine();
            int posInLine = token.getCharPositionInLine();
            int startOffset = token.getStartIndex();
            int endOffset = token.getStopIndex();
            return new BuildingIssue(message, cause, false, lineNumber, posInLine, startOffset,
                endOffset);
        }
        return new BuildingIssue(message, cause, false, -1, -1, -1, -1);
    }

    public static BuildingIssue createWarning(String message,
            @Nullable ParserRuleContext token, @Nullable Throwable cause) {
        return createWarning(message, token != null ? token.start : null, cause);
    }

    public static BuildingIssue createWarning(String message, @Nullable Token token,
            @Nullable Throwable cause) {
        if (token != null) {
            int lineNumber = token.getLine();
            int posInLine = token.getCharPositionInLine();
            int startOffset = token.getStartIndex();
            int endOffset = token.getStopIndex();
            return new BuildingIssue(message, cause, true, lineNumber, posInLine, startOffset,
                endOffset);
        }
        return new BuildingIssue(message, cause, true, -1, -1, -1, -1);
    }


    public int getLineNumber() {
        return lineNumber;
    }

    public int getPosInLine() {
        return posInLine;
    }

    public int getStartOffset() {
        return startOffset;
    }

    public int getEndOffset() {
        return endOffset;
    }
}
