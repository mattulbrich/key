This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.control.event;

import java.util.EventListener;

import de.uka.ilkd.key.control.TermLabelVisibilityManager;

/**
 * Observes changes on a {@link TermLabelVisibilityManager}.
 *
 * @author Martin Hentschel
 */
public interface TermLabelVisibilityManagerListener extends EventListener {
    /**
     * When the visible term labels have changed.
     *
     * @param e The change event.
     */
    public void visibleLabelsChanged(TermLabelVisibilityManagerEvent e);
}
