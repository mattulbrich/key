This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.symbolic_execution.model;

import de.uka.ilkd.key.java.SourceElement;
import de.uka.ilkd.key.symbolic_execution.SymbolicExecutionTreeBuilder;
import de.uka.ilkd.key.symbolic_execution.model.impl.ExecutionJoin;

/**
 * <p>
 * A node in the symbolic execution tree which represents a join.
 * </p>
 * <p>
 * The default implementation is {@link ExecutionJoin} which
 * is instantiated via a {@link SymbolicExecutionTreeBuilder} instance.
 * </p>
 *
 * @author Martin Hentschel
 * @see SymbolicExecutionTreeBuilder
 * @see ExecutionJoin
 */
public interface IExecutionJoin extends IExecutionNode<SourceElement> {
    /**
     * Checks if the weakening is verified.
     *
     * @return {@code true} is verified, {@code false} is not verified.
     */
    public boolean isWeakeningVerified();

    /**
     * Checks if the weakening verification is supported.
     *
     * @return {@code true} supported, {@code false} not supported.
     */
    public boolean isWeakeningVerificationSupported();
}
