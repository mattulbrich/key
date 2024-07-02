This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.symbolic_execution.model;

import de.uka.ilkd.key.logic.Term;
import de.uka.ilkd.key.symbolic_execution.model.impl.ExecutionConstraint;

/**
 * <p>
 * A constrained considered during symbolic execution.
 * </p>
 * <p>
 * The default implementation is {@link ExecutionConstraint} which
 * is instantiated lazily by the {@link IExecutionNode} and
 * {@link IExecutionValue} implementations.
 * </p>
 *
 * @author Martin Hentschel
 * @see IExecutionNode
 * @see IExecutionValue
 * @see ExecutionConstraint
 */
public interface IExecutionConstraint extends IExecutionElement {
    /**
     * Returns the {@link Term} representing the constraint.
     *
     * @return The {@link Term} representing the constraint.
     */
    public Term getTerm();
}
