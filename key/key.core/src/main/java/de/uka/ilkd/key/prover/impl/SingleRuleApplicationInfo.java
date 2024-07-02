This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.prover.impl;

import de.uka.ilkd.key.proof.Goal;
import de.uka.ilkd.key.rule.RuleApp;

/**
 * Instances of this class are used to store if a rule could be applied automatically and if not
 * to store the reason why no rule applications could be performed. Because of performance reason
 * the
 * success case returns the singleton {@link SingleRuleApplicationInfo#SUCCESS}
 */
public class SingleRuleApplicationInfo {

    private boolean success;
    private final String message;
    private final Goal goal;
    private RuleApp appliedRuleApp;

    SingleRuleApplicationInfo(Goal mayCloseableGoal, RuleApp appliedRuleApp) {
        this.message = "Rule applied successful";
        this.goal = mayCloseableGoal;
        this.appliedRuleApp = appliedRuleApp;
        this.success = true;
    }

    SingleRuleApplicationInfo(String message, Goal nonCloseableGoal, RuleApp appliedRuleApp) {
        this.message = message;
        this.goal = nonCloseableGoal;
        this.appliedRuleApp = appliedRuleApp;
        this.success = false;
    }

    public boolean isSuccess() {
        return success;
    }

    public Goal getGoal() {
        return goal;
    }

    public String message() {
        return message;
    }

    public RuleApp getAppliedRuleApp() {
        return appliedRuleApp;
    }
}
