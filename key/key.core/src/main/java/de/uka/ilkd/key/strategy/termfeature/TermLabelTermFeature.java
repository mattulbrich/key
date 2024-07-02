This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.strategy.termfeature;

import de.uka.ilkd.key.java.Services;
import de.uka.ilkd.key.logic.Term;
import de.uka.ilkd.key.logic.label.TermLabel;

/**
 * A termfeature that can be used to check whether a term has a specific label
 * {@link #create(TermLabel)}
 * or any label {{@link #HAS_ANY_LABEL} at all.
 */
public class TermLabelTermFeature extends BinaryTermFeature {

    public static final TermFeature HAS_ANY_LABEL = new TermLabelTermFeature(null);

    public static TermFeature create(TermLabel label) {
        return new TermLabelTermFeature(label);
    }


    private final TermLabel label;

    private TermLabelTermFeature(TermLabel label) {
        this.label = label;
    }

    @Override
    protected boolean filter(Term term, Services services) {
        if (label == null) {
            return term.hasLabels();
        }
        return term.containsLabel(label);
    }
}
