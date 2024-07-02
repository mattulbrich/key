This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.proof.event;

import de.uka.ilkd.key.proof.Proof;

/**
 * Observes a {@link Proof}.
 *
 * @author Martin Hentschel
 */
public interface ProofDisposedListener {
    /**
     * When a {@link Proof} is going to be disposed.
     *
     * @param e The event.
     */
    public void proofDisposing(ProofDisposedEvent e);

    /**
     * When a {@link Proof} was disposed via {@link Proof#dispose()}.
     *
     * @param e The event.
     */
    public void proofDisposed(ProofDisposedEvent e);
}
