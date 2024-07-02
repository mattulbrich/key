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


/**
 *
 * The comment below was the description used in the variable condition:
 *
 * <quote>In the taclet language the variable condition is called "\isInductVar".
 * This variable condition checks if a logical variable is marked as an induction variable.
 * A variable is marked as such if its name has the suffix is "Ind" or "IND" and the name has
 * length>3.
 *
 * @author gladisch</quote>
 */
public class IsInductionVariable extends BinaryTermFeature {

    public static final TermFeature INSTANCE = new IsInductionVariable();

    private IsInductionVariable() {}

    @Override
    protected boolean filter(Term term, Services services) {
        // this has been copied from the former InductionVariableCondition
        // TODO: use termlabels instead of names?
        final String name = term.op().toString();
        if (name.length() > 3) {
            final String suffix = name.substring(name.length() - 3);
            if (suffix.equals("Ind") || suffix.equals("IND")) {
                return true;
            }
        }
        return false;
    }

}
