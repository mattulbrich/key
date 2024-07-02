This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.symbolic_execution.util.event;

import java.util.EventListener;

import de.uka.ilkd.key.symbolic_execution.util.SideProofStore;
import de.uka.ilkd.key.symbolic_execution.util.SideProofStore.Entry;

/**
 * Observes changes on a {@link SideProofStore}.
 *
 * @author Martin Hentschel
 */
public interface ISideProofStoreListener extends EventListener {
    /**
     * When new {@link Entry}s are added.
     *
     * @param e The {@link SideProofStoreEvent}.
     */
    public void entriesAdded(SideProofStoreEvent e);

    /**
     * When existing {@link Entry}s were removed.
     *
     * @param e The {@link SideProofStoreEvent}.
     */
    public void entriesRemoved(SideProofStoreEvent e);
}
