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

import org.key_project.util.collection.ImmutableList;

/**
 * An extended {@link IExecutionNode} which groups several child nodes.
 *
 * @author Martin Hentschel
 */
public interface IExecutionBlockStartNode<S extends SourceElement> extends IExecutionNode<S> {
    /**
     * Checks if a block might be opened.
     *
     * @return {@code false} block is definitively not opened, {@code true} block is or might be
     *         opened.
     */
    public boolean isBlockOpened();

    /**
     * Returns the up to now discovered {@link IExecutionNode}s.
     *
     * @return The up to now discovered {@link IExecutionNode}s.
     */
    public ImmutableList<IExecutionNode<?>> getBlockCompletions();
}
