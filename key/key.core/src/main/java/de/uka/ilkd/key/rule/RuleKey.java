This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.rule;

import javax.annotation.Nonnull;

import de.uka.ilkd.key.logic.Choice;
import de.uka.ilkd.key.logic.Name;

import org.key_project.util.collection.DefaultImmutableSet;
import org.key_project.util.collection.ImmutableSet;


/**
 * Provides a unique key for taclets based on a taclet's name and its taclet options.
 * This class is e.g. used by the parser which might encounter more than one taclet of
 * the same name (but with different taclet options).
 *
 * One does not need to use this implementation (but can rely on a taclet's own
 * {@link Taclet#equals(Object)} and {@link Taclet#hashCode()} method.
 */
public class RuleKey {
    public final @Nonnull Name name;
    public final @Nonnull ImmutableSet<Choice> choices;
    public final Rule r;

    RuleKey(@Nonnull Name name, @Nonnull ImmutableSet<Choice> choices, Rule r) {
        this.name = name;
        this.choices = choices;
        this.r = r;
    }

    public RuleKey(Rule r) {
        this(r.name(), (r instanceof Taclet ? ((Taclet) r).getChoices()
                : DefaultImmutableSet.<Choice>nil()),
            r);
    }

    public boolean equals(Object o) {
        if (o == null)
            return false;
        if (o == this)
            return true;

        if (o.getClass() != this.getClass())
            return false;

        final RuleKey other = (RuleKey) o;
        return name.equals(other.name) && choices.equals(other.choices);
    }

    public int hashCode() {
        return name.hashCode() * 17 + 7 * choices.hashCode();
    }

    public String toString() {
        return "(" + name + ", " + choices + ")";
    }

}
