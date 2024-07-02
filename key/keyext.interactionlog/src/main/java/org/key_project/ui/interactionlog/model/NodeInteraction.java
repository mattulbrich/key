This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package org.key_project.ui.interactionlog.model;

import java.beans.Transient;
import javax.xml.bind.annotation.XmlTransient;

import de.uka.ilkd.key.proof.Node;
import de.uka.ilkd.key.proof.Proof;

import org.key_project.ui.interactionlog.api.Interaction;

@XmlTransient
public abstract class NodeInteraction extends Interaction {
    private static final long serialVersionUID = 1L;

    private transient int serialNr;

    private NodeIdentifier nodeId;

    public NodeInteraction() {}

    protected NodeInteraction(Node node) {
        this.serialNr = node.serialNr();
        this.nodeId = NodeIdentifier.get(node);
    }

    @Transient()
    public int getSerialNr() {
        return serialNr;
    }

    public NodeIdentifier getNodeId() {
        return nodeId;
    }

    public void setNodeId(NodeIdentifier nodeId) {
        this.nodeId = nodeId;
    }

    public Node getNode(Proof proof) {
        return nodeId.findNode(proof).orElse(null);
    }
}
