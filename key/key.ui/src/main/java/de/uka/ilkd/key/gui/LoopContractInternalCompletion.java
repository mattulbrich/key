This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.gui;

import java.util.List;

import de.uka.ilkd.key.java.Services;
import de.uka.ilkd.key.logic.op.LocationVariable;
import de.uka.ilkd.key.proof.Goal;
import de.uka.ilkd.key.rule.AbstractAuxiliaryContractRule.Instantiation;
import de.uka.ilkd.key.rule.IBuiltInRuleApp;
import de.uka.ilkd.key.rule.LoopContractInternalBuiltInRuleApp;
import de.uka.ilkd.key.rule.LoopContractInternalRule;
import de.uka.ilkd.key.speclang.HeapContext;
import de.uka.ilkd.key.speclang.LoopContract;

import org.key_project.util.collection.ImmutableSet;

/**
 * Interactive completion for {@link LoopContractInternalBuiltInRuleApp}.
 */
public class LoopContractInternalCompletion implements InteractiveRuleApplicationCompletion {

    private final MainWindow mainWindow;

    LoopContractInternalCompletion(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }

    @Override
    public IBuiltInRuleApp complete(final IBuiltInRuleApp application,
            final Goal goal, final boolean force) {
        LoopContractInternalBuiltInRuleApp result =
            (LoopContractInternalBuiltInRuleApp) application;
        if (!result.complete() && result.cannotComplete(goal)) {
            return result;
        }
        if (force) {
            result.tryToInstantiate(goal);
            if (result.complete()) {
                return result;
            }
        }
        final Services services = goal.proof().getServices();
        final Instantiation instantiation =
            LoopContractInternalRule.INSTANCE
                    .instantiate(application.posInOccurrence().subTerm(), goal, services);
        final ImmutableSet<LoopContract> contracts =
            LoopContractInternalRule.getApplicableContracts(instantiation, goal, services);
        final AuxiliaryContractConfigurator<LoopContract> configurator =
            new AuxiliaryContractConfigurator<>("Loop Contract Configurator",
                new LoopContractSelectionPanel(services, true),
                mainWindow, services, contracts.toArray(new LoopContract[contracts.size()]),
                "Contracts for Block: " + instantiation.statement);
        if (configurator.wasSuccessful()) {
            final List<LocationVariable> heaps =
                HeapContext.getModHeaps(services, instantiation.isTransactional());
            result.update(instantiation.statement, configurator.getContract(), heaps);
        }
        return result;
    }

    @Override
    public boolean canComplete(final IBuiltInRuleApp app) {
        return checkCanComplete(app);
    }

    /**
     * Checks if the app is supported.
     * This functionality is also used by the Eclipse plug-ins like the KeYIDE.
     */
    public static boolean checkCanComplete(final IBuiltInRuleApp app) {
        return app.rule() instanceof LoopContractInternalRule;
    }
}
