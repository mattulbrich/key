This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.control.event;

import java.util.EventObject;

import de.uka.ilkd.key.control.TermLabelVisibilityManager;

/**
 * An event thrown by a {@link TermLabelVisibilityManager}.
 *
 * @author Martin Hentschel
 */
public class TermLabelVisibilityManagerEvent extends EventObject {
    /**
     * Generated UID.
     */
    private static final long serialVersionUID = 2827200355462914026L;

    /**
     * Constructor.
     *
     * @param source The source {@link TermLabelVisibilityManager}.
     */
    public TermLabelVisibilityManagerEvent(TermLabelVisibilityManager source) {
        super(source);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TermLabelVisibilityManager getSource() {
        return (TermLabelVisibilityManager) super.getSource();
    }
}
