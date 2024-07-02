This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.api;

import de.uka.ilkd.key.logic.Sequent;
import de.uka.ilkd.key.proof.Node;
import de.uka.ilkd.key.proof.NodeInfo;

/**
 * Wrapper for a proof node with utilities methods to
 *
 * @author Sarah Grebing
 * @author Alexander Weigl
 */
public class ProjectedNode {

    private final Node proofNode;

    private final ProjectedNode parent;

    /**
     * Creates the wrapper object for a proof node
     *
     * @param node
     * @param parent
     */
    public ProjectedNode(Node node, ProjectedNode parent) {
        this.proofNode = node;
        this.parent = parent;
    }

    /**
     * Return the sequent of a proof node
     *
     * @return de.uka.ilkd.key.logic.Sequent s
     */
    public Sequent getSequent() {
        return proofNode.sequent();
    }

    public ProjectedNode getParent() {
        return this.parent;
    }

    public boolean isRoot() {
        return getParent() == null;
    }

    public NodeInfo getNodeInfo() {
        return proofNode.getNodeInfo();
    }

    public boolean isPseudoNode() {
        return proofNode == null;
    }

    public Node getProofNode() {
        return proofNode;
    }

    public static ProjectedNode pseudoRoot() {
        return new ProjectedNode(null, null);
    }
}
