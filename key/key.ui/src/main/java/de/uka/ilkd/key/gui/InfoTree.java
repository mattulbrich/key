This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.gui;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 * This class is used by {@link InfoView} to display its contents.
 *
 * @author Kai Wallisch <kai.wallisch@ira.uka.de>
 */
public class InfoTree extends JTree {

    /**
     *
     */
    private static final long serialVersionUID = 2018185104131516569L;

    InfoTree() {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode();
        root.add(new InfoTreeNode("No proof loaded",
            "In this pane, the available logical rules will be displayed and/or explained."));
        setModel(new DefaultTreeModel(root));
        setShowsRootHandles(true);
        setRootVisible(false);
    }

    /*
     * This function is expected to return only {@link InfoTreeNode} instances.
     * The super method returns {@link DefaultMutableTreeNode} instances.
     */
    @Override
    public InfoTreeNode getLastSelectedPathComponent() {
        return (InfoTreeNode) super.getLastSelectedPathComponent();
    }

}
