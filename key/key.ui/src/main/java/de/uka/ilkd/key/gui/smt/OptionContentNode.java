This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.gui.smt;

import javax.swing.JComponent;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 * @author Mihai Herda, 2018
 */

public class OptionContentNode extends DefaultMutableTreeNode {
    private static final long serialVersionUID = 1L;
    private final JComponent component;

    public OptionContentNode(String title, JComponent component) {
        super();
        this.component = component;
        this.setUserObject(title);
    }

    public JComponent getComponent() {
        return component;
    }

}
