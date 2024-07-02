This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.symbolic_execution.model.impl;

import de.uka.ilkd.key.logic.PosInOccurrence;
import de.uka.ilkd.key.logic.Term;
import de.uka.ilkd.key.proof.Node;
import de.uka.ilkd.key.proof.init.ProofInputException;
import de.uka.ilkd.key.symbolic_execution.model.IExecutionConstraint;
import de.uka.ilkd.key.symbolic_execution.model.IExecutionNode;
import de.uka.ilkd.key.symbolic_execution.model.ITreeSettings;

/**
 * The default implementation of {@link IExecutionConstraint}.
 *
 * @author Martin Hentschel
 */
public class ExecutionConstraint extends AbstractExecutionElement implements IExecutionConstraint {
    /**
     * The {@link Term} representing the constraint.
     */
    private final Term term;

    /**
     * The {@link PosInOccurrence} of the modality of interest.
     */
    private final PosInOccurrence modalityPIO;

    /**
     * Constructor.
     *
     * @param settings The {@link ITreeSettings} to use.
     * @param proofNode The {@link Node} of KeY's proof tree which is represented by this
     *        {@link IExecutionNode}.
     * @param term The {@link Term} representing the constraint.
     */
    public ExecutionConstraint(ITreeSettings settings, Node proofNode, PosInOccurrence modalityPIO,
            Term term) {
        super(settings, proofNode);
        assert term != null;
        assert modalityPIO != null;
        this.term = term;
        this.modalityPIO = modalityPIO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String lazyComputeName() throws ProofInputException {
        return formatTerm(term, getServices());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getElementType() {
        return "Constraint";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Term getTerm() {
        return term;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PosInOccurrence getModalityPIO() {
        return modalityPIO;
    }
}
