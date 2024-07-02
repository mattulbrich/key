This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.gui.prooftree;

import javax.annotation.Nonnull;

/**
 * A {@code Styler} is a part of a strategy to implement a flexible mechanism for the representation
 * of elements.
 * For example, the proof tree uses a list of {@code Styler}s to determine the look of proof nodes
 * in the JTree.
 *
 * @param <T> is an arbitrary type specifying the argument to judge on
 * @author Alexander Weigl
 * @version 1 (20.05.19)
 */
public interface Styler<T> {
    /**
     * Set the required style information in {@code current} accordingly to the object given in
     * {@code obj}.
     */
    void style(@Nonnull Style current, @Nonnull T obj);
}
