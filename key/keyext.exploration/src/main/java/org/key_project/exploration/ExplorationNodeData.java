This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package org.key_project.exploration;

import java.util.Objects;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import de.uka.ilkd.key.proof.Node;

/**
 * Information on exploration that is attached to nodes.
 * If such an object is attached to a node, this node will be highlighted in the tree with a border
 * and if an ExplorationAction is set this action is displayed in the ExplorationStepsList Tab
 */
public class ExplorationNodeData {

    private String explorationAction;

    public static @Nonnull ExplorationNodeData get(@Nonnull Node node) {
        @Nullable
        ExplorationNodeData data = node.lookup(ExplorationNodeData.class);
        if (data == null) {
            data = new ExplorationNodeData();
            node.register(data, ExplorationNodeData.class);
        }
        return data;
    }

    /**
     * Return the String of the Exploration action that was applied to the node
     */
    public String getExplorationAction() {
        return explorationAction;
    }

    /**
     * Set the String of the Exploration action that was applied to the node
     */
    public void setExplorationAction(String explorationAction) {
        this.explorationAction = explorationAction;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (o.getClass() != getClass())
            return false;
        ExplorationNodeData that = (ExplorationNodeData) o;
        return Objects.equals(getExplorationAction(), that.getExplorationAction());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getExplorationAction());
    }
}
