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
import de.uka.ilkd.key.rule.AbstractLoopContractBuiltInRuleApp;
import de.uka.ilkd.key.speclang.LoopContract;
import de.uka.ilkd.key.speclang.LoopContractImpl;

import org.key_project.util.collection.DefaultImmutableSet;
import org.key_project.util.collection.ImmutableSet;

/**
 * This panel used to select which {@link LoopContract}s to use for an
 * {@link AbstractLoopContractBuiltInRuleApp}.
 */
public class LoopContractSelectionPanel extends AuxiliaryContractSelectionPanel<LoopContract> {

    private static final long serialVersionUID = 5832235501095794321L;

    public LoopContractSelectionPanel(Services services,
            boolean multipleSelection) {
        super(services, multipleSelection);
    }

    @Override
    public LoopContract computeContract(Services services,
            List<LoopContract> selection) {
        if (selection.isEmpty()) {
            return null;
        } else if (selection.size() == 1) {
            return selection.get(0);
        } else {
            ImmutableSet<LoopContract> contracts = DefaultImmutableSet.nil();
            for (LoopContract contract : selection) {
                contracts = contracts.add(contract);
            }
            return LoopContractImpl.combine(contracts, services);
        }
    }
}
