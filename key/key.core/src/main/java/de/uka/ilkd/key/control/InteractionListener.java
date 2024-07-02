This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.control;

import java.util.List;

import de.uka.ilkd.key.logic.PosInOccurrence;
import de.uka.ilkd.key.macros.ProofMacro;
import de.uka.ilkd.key.macros.ProofMacroFinishedInfo;
import de.uka.ilkd.key.proof.Goal;
import de.uka.ilkd.key.proof.Node;
import de.uka.ilkd.key.proof.Proof;
import de.uka.ilkd.key.prover.impl.ApplyStrategyInfo;
import de.uka.ilkd.key.rule.BuiltInRule;
import de.uka.ilkd.key.rule.IBuiltInRuleApp;
import de.uka.ilkd.key.rule.RuleApp;
import de.uka.ilkd.key.settings.Settings;

/**
 * @author Alexander Weigl
 * @version 1 (08.12.18)
 */
public interface InteractionListener {
    void settingChanged(Proof proof, Settings settings, SettingType type, String message);

    void runPrune(Node node);

    void runMacro(Node node, ProofMacro macro, PosInOccurrence posInOcc,
            ProofMacroFinishedInfo info);

    void runBuiltInRule(Goal goal, IBuiltInRuleApp app, BuiltInRule rule,
            PosInOccurrence pos, boolean forced);

    void runAutoMode(List<Node> initialGoals, Proof proof, ApplyStrategyInfo info);

    void runRule(Goal goal, RuleApp app);


    public enum SettingType {
        SMT, CHOICE, STRATEGY
    }
}
