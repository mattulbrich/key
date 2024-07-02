This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.proof.io.intermediate;

/**
 * Node in an intermediate proof representation storing a rule application.
 *
 * @author Dominic Scheurer
 */
public class AppNodeIntermediate extends NodeIntermediate {

    private AppIntermediate ruleApp = null;
    private boolean interactiveRuleApplication = false;
    /** Signals that this app has been triggered by a proof script. */
    private boolean scriptRuleApplication = false;
    /** user-provided notes for the node */
    private String notes = null;

    public AppIntermediate getIntermediateRuleApp() {
        return ruleApp;
    }

    public void setIntermediateRuleApp(AppIntermediate ruleApp) {
        this.ruleApp = ruleApp;
    }

    public boolean isInteractiveRuleApplication() {
        return interactiveRuleApplication;
    }

    public boolean isScriptRuleApplication() {
        return scriptRuleApplication;
    }

    public void setInteractiveRuleApplication(boolean interactiveRuleApplication) {
        this.interactiveRuleApplication = interactiveRuleApplication;
    }

    public void setScriptRuleApplication(boolean scriptRuleApplication) {
        this.scriptRuleApplication = scriptRuleApplication;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getNotes() {
        return notes;
    }
}
