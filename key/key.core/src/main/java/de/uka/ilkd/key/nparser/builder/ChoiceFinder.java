This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.nparser.builder;

import java.util.*;
import javax.annotation.Nonnull;

import de.uka.ilkd.key.logic.Choice;
import de.uka.ilkd.key.logic.Name;
import de.uka.ilkd.key.logic.Namespace;
import de.uka.ilkd.key.nparser.ChoiceInformation;
import de.uka.ilkd.key.nparser.KeYParser;

/**
 * This visitor gathers the choice information in {@link de.uka.ilkd.key.nparser.KeyAst.File}
 * and provide {@link ChoiceInformation}.
 *
 * @author Alexander Weigl
 * @version 1 (28.10.19)
 * @see ChoiceInformation
 */
public class ChoiceFinder extends AbstractBuilder<Object> {
    @Nonnull
    private final ChoiceInformation choiceInformation;

    public ChoiceFinder() {
        choiceInformation = new ChoiceInformation();
    }

    public ChoiceFinder(@Nonnull ChoiceInformation choiceInformation) {
        this.choiceInformation = choiceInformation;
    }

    public ChoiceFinder(Namespace<Choice> choices) {
        choiceInformation = new ChoiceInformation(choices);
    }

    @Override
    public Object visitDecls(KeYParser.DeclsContext ctx) {
        ctx.option_decls().forEach(this::accept);
        ctx.options_choice().forEach(this::accept);
        return null;
    }

    @Override
    public Object visitChoice(KeYParser.ChoiceContext ctx) {
        String category = ctx.category.getText();
        List<String> options = new ArrayList<>(ctx.optionDecl().size());
        ctx.optionDecl().forEach(it -> {
            options.add(it.IDENT.getText());
        });
        if (options.isEmpty()) {
            options.add("on");
            options.add("off");
        }

        seq().put(category, new HashSet<>(options));
        choiceInformation.setDefaultOption(category, options.get(0));
        options.forEach(it -> choices().add(new Choice(it, category)));
        return null;
    }

    @Override
    public Choice visitActivated_choice(KeYParser.Activated_choiceContext ctx) {
        String cat = ctx.cat.getText();
        String ch = ctx.choice_.getText();
        if (activatedChoicesCategories().contains(cat)) {
            throw new IllegalArgumentException(
                "You have already chosen a different option for " + cat);
        }
        activatedChoicesCategories().add(cat);
        String name = cat + ":" + ch;
        Choice c = choices().lookup(new Name(name));
        if (c == null) {
            c = new Choice(ch, cat);
            choices().add(c);
            // weigl: hitted by several test caes:
            // semanticError(ctx, "Choice %s not previously declared", name);
        }
        activatedChoices().add(c);
        return c;
    }

    @Nonnull
    public ChoiceInformation getChoiceInformation() {
        return choiceInformation;
    }

    // region access functions
    private Set<Choice> activatedChoices() {
        return choiceInformation.getActivatedChoices();
    }

    private HashSet<String> activatedChoicesCategories() {
        return choiceInformation.getActivatedChoicesCategories();
    }

    private HashSet<String> options() {
        return choiceInformation.getActivatedChoicesCategories();
    }

    private Namespace<Choice> choices() {
        return choiceInformation.getChoices();
    }

    private Map<String, Set<String>> seq() {
        return choiceInformation.getFoundChoicesAndOptions();
    }
    // endregion
}
