This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.smt.counterexample;

import de.uka.ilkd.key.control.UserInterfaceControl;
import de.uka.ilkd.key.logic.Choice;
import de.uka.ilkd.key.logic.Sequent;
import de.uka.ilkd.key.proof.Proof;
import de.uka.ilkd.key.proof.init.ProofInputException;
import de.uka.ilkd.key.proof.mgt.ProofEnvironment;
import de.uka.ilkd.key.rule.OneStepSimplifier;
import de.uka.ilkd.key.util.ProofStarter;
import de.uka.ilkd.key.util.SideProofUtil;

/**
 * Implementation of {@link AbstractCounterExampleGenerator} which instantiates
 * the new {@link Proof} as side proof.
 */
public abstract class AbstractSideProofCounterExampleGenerator
        extends AbstractCounterExampleGenerator {
    /**
     * {@inheritDoc}
     */
    @Override
    protected Proof createProof(UserInterfaceControl ui, Proof oldProof, Sequent oldSequent,
            String proofName) throws ProofInputException {
        Sequent newSequent = createNewSequent(oldSequent);
        ProofEnvironment env =
            SideProofUtil.cloneProofEnvironmentWithOwnOneStepSimplifier(oldProof,
                new Choice("ban", "runtimeExceptions"));
        ProofStarter starter = SideProofUtil.createSideProof(env, newSequent, proofName);
        Proof proof = starter.getProof();
        OneStepSimplifier.refreshOSS(proof);
        return proof;
    }
}
