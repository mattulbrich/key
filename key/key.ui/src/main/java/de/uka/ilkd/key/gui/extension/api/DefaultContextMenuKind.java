This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.gui.extension.api;

import de.uka.ilkd.key.pp.PosInSequent;
import de.uka.ilkd.key.proof.Node;
import de.uka.ilkd.key.proof.Proof;
import de.uka.ilkd.key.rule.Rule;

/**
 * @author Alexander Weigl
 * @version 1 (07.04.19)
 */
public enum DefaultContextMenuKind implements ContextMenuKind {
    PROOF_LIST(Proof.class),
    PROOF_TREE(Node.class),
    TACLET_INFO(Rule.class),
    SEQUENT_VIEW(PosInSequent.class);

    private final Class<?> clazz;

    DefaultContextMenuKind(Class<?> clazz) {
        this.clazz = clazz;
    }

    public Class<?> getType() {
        return clazz;
    }
}
