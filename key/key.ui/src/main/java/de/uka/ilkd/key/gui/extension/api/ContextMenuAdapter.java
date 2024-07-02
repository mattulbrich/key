This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.gui.extension.api;

import java.util.Collections;
import java.util.List;
import javax.swing.*;

import de.uka.ilkd.key.core.KeYMediator;
import de.uka.ilkd.key.pp.PosInSequent;
import de.uka.ilkd.key.proof.Node;
import de.uka.ilkd.key.proof.Proof;
import de.uka.ilkd.key.rule.Rule;

/**
 * @author Alexander Weigl
 * @version 1 (16.04.19)
 */
public abstract class ContextMenuAdapter implements KeYGuiExtension.ContextMenu {
    @Override
    public final List<Action> getContextActions(KeYMediator mediator, ContextMenuKind kind,
            Object underlyingObject) {
        switch ((DefaultContextMenuKind) kind) {
        case PROOF_LIST:
            return getContextActions(mediator, kind, (Proof) underlyingObject);
        case PROOF_TREE:
            return getContextActions(mediator, kind, (Node) underlyingObject);
        case TACLET_INFO:
            return getContextActions(mediator, kind, (Rule) underlyingObject);
        case SEQUENT_VIEW:
            return getContextActions(mediator, kind, (PosInSequent) underlyingObject);
        default:
            throw new IllegalArgumentException("unexpected kind");
        }
    }

    public List<Action> getContextActions(KeYMediator mediator, ContextMenuKind kind,
            Proof underlyingObject) {
        return Collections.emptyList();
    }

    public List<Action> getContextActions(KeYMediator mediator, ContextMenuKind kind,
            Node underlyingObject) {
        return Collections.emptyList();
    }

    public List<Action> getContextActions(KeYMediator mediator, ContextMenuKind kind,
            PosInSequent underlyingObject) {
        return Collections.emptyList();
    }

    public List<Action> getContextActions(KeYMediator mediator, ContextMenuKind kind,
            Rule underlyingObject) {
        return Collections.emptyList();
    }
}
