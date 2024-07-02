This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.speclang.njml;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import de.uka.ilkd.key.logic.label.OriginTermLabel;
import de.uka.ilkd.key.logic.label.TermLabel;

import org.antlr.v4.runtime.ParserRuleContext;

/**
 * This class maps a {@link ParserRuleContext} to a {@link TermLabel}.
 */
public class LabeledParserRuleContext {
    @Nonnull
    public final ParserRuleContext first;
    @Nullable
    public final TermLabel second;

    public LabeledParserRuleContext(ParserRuleContext first, TermLabel second) {
        if (first == null)
            throw new IllegalArgumentException("ParserRuleContext is null");
        this.first = first;
        this.second = second;
    }


    public LabeledParserRuleContext(ParserRuleContext first) {
        if (first == null)
            throw new IllegalArgumentException("ParserRuleContext is null");
        this.first = first;
        second = null;
    }

    public LabeledParserRuleContext(ParserRuleContext ctx, OriginTermLabel.SpecType specType) {
        this(ctx, constructTermLabel(ctx, specType));
    }

    private static TermLabel constructTermLabel(ParserRuleContext ctx,
            OriginTermLabel.SpecType specType) {
        String filename = ctx.start.getTokenSource().getSourceName();
        int line = ctx.start.getLine();
        OriginTermLabel.Origin origin = new OriginTermLabel.FileOrigin(specType, filename, line);
        return new OriginTermLabel(origin);
    }
}
