This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.logic;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import de.uka.ilkd.key.java.Services;

/**
 * A generic {@link Term} replace visitor based on a filter predicate and a
 * replacement function for the filtered subterms.
 *
 * @author Dominic Steinhoefel
 */
public class GenericTermReplacer {
    public static Term replace(final Term t, final Predicate<Term> filter,
            final Function<Term, Term> replacer, Services services) {
        Term newTopLevelTerm = t;
        if (filter.test(t)) {
            newTopLevelTerm = replacer.apply(t);
        }

        final Term[] newSubs = newTopLevelTerm.subs().stream()
                .map(sub -> replace(sub, filter, replacer, services)).collect(Collectors.toList())
                .toArray(new Term[0]);

        return services.getTermFactory().createTerm(newTopLevelTerm.op(), newSubs,
            newTopLevelTerm.boundVars(), newTopLevelTerm.javaBlock(),
            newTopLevelTerm.getLabels());
    }
}
