package de.uka.ilkd.key.gui.actions.useractions;

import de.uka.ilkd.key.core.KeYMediator;
import de.uka.ilkd.key.proof.Proof;

/**
 * User action to start auto mode (automatic proof search).
 *
 * @author Arne Keller
 */
public class AutoModeUserAction extends ProofModifyingUserAction {

    /**
     * Construct a new auto mode user action.
     *
     * @param mediator mediator
     * @param proof selected proof
     */
    public AutoModeUserAction(KeYMediator mediator, Proof proof) {
        super(mediator, proof);
    }

    @Override
    public String name() {
        return "Strategy: Auto Mode";
    }

    @Override
    protected void apply() {
        mediator.getUI().getProofControl().startAutoMode(proof, proof.openEnabledGoals());
    }
}
