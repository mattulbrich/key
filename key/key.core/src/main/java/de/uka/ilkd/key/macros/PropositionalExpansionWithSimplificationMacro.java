This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.macros;

import java.util.Set;

/**
 *
 * @author christoph
 */
public class PropositionalExpansionWithSimplificationMacro
        extends AbstractPropositionalExpansionMacro {

    @Override
    public String getName() {
        return "Propositional Expansion (w/o Splits) + Simplification";
    }

    @Override
    public String getDescription() {
        return "Apply rules to decompose propositional toplevel formulas; " +
            "does not split the goal. Applies one step simplifications.";
    }

    private static final String[] ADMITTED_RULES = {
        "andLeft", "orRight", "impRight", "notLeft", "notRight", "close",
        "One Step Simplification"
    };

    private static final Set<String> ADMITTED_RULES_SET = asSet(ADMITTED_RULES);

    @Override
    protected Set<String> getAdmittedRuleNames() {
        return ADMITTED_RULES_SET;
    }

    @Override
    protected boolean allowOSS() {
        return false;
    }
}
