This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.gui;

import de.uka.ilkd.key.proof.Goal;
import de.uka.ilkd.key.rule.IBuiltInRuleApp;
import de.uka.ilkd.key.rule.LoopApplyHeadBuiltInRuleApp;

/**
 * Interactive completion for {@link LoopApplyHeadBuiltInRuleApp}.
 */
public class LoopApplyHeadCompletion
        implements InteractiveRuleApplicationCompletion {

    LoopApplyHeadCompletion(MainWindow mainWindow) {}

    @Override
    public IBuiltInRuleApp complete(final IBuiltInRuleApp application,
            final Goal goal, final boolean force) {
        LoopApplyHeadBuiltInRuleApp result =
            (LoopApplyHeadBuiltInRuleApp) application;
        if (!result.complete() && result.cannotComplete(goal)) {
            return result;
        }

        result.tryToInstantiate(goal);
        return result;
    }

    @Override
    public boolean canComplete(final IBuiltInRuleApp app) {
        return app instanceof LoopApplyHeadBuiltInRuleApp;
    }
}
