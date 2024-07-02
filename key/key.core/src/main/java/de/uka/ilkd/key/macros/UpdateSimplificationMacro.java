This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.macros;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * This macro applies only update simplification rules.
 *
 * @author Richard Bubel
 */
public class UpdateSimplificationMacro extends
        AbstractPropositionalExpansionMacro {

    public static final String UPDATE_SIMPLIFICATION_ONLY = "Update Simplification Only";

    private static final String[] ADMITTED_RULE_NAMES = {
        "simplifyUpdate1",
        "simplifyUpdate2",
        "simplifyUpdate3",
        "sequentialToParallel1",
        "sequentialToParallel2",
        "sequentialToParallel3",
        "applyOnRigidTerm",
        "applyOnRigidFormula",
        "applyOnElementary",
        "applyOnParallel",
        "applyOnSkip",
        "applyOnPV",
        "parallelWithSkip1",
        "parallelWithSkip2",
        "applySkip1",
        "applySkip2",
    };

    private static final Set<String> ADMITTED_RULE_NAMES_AS_SET = new HashSet<String>();
    static {
        Collections.addAll(ADMITTED_RULE_NAMES_AS_SET, ADMITTED_RULE_NAMES);
    }


    @Override
    public String getName() {
        return UPDATE_SIMPLIFICATION_ONLY;
    }

    @Override
    public String getCategory() {
        return "Simplification";
    }

    @Override
    public String getScriptCommandName() {
        return "simp-upd";
    }

    @Override
    public String getDescription() {
        return "Applies only update simplification rules";
    }

    @Override
    protected Set<String> getAdmittedRuleNames() {
        return ADMITTED_RULE_NAMES_AS_SET;
    }

    @Override
    protected boolean allowOSS() {
        return true;
    }

}
