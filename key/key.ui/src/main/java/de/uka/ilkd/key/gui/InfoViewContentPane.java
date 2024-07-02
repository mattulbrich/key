This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.gui;

import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * This class is used to display descriptions in {@link InfoView}.
 *
 * @author Kai Wallisch <kai.wallisch@ira.uka.de>
 */
public class InfoViewContentPane extends JScrollPane {

    /**
     *
     */
    private static final long serialVersionUID = -7609483136106706196L;
    private final JTextArea description;

    InfoViewContentPane() {
        description = new JTextArea("", 15, 30);
        description.setEditable(false);
        description.setLineWrap(true);
        description.setWrapStyleWord(true);
        setViewportView(description);
    }

    public void setNode(InfoTreeNode node) {
        setBorder(BorderFactory.createTitledBorder(node.getTitle()));
        description.setText(node.getDescription());
        description.setCaretPosition(0);
    }

    public void clear() {
        setBorder(BorderFactory.createTitledBorder("Description"));
        description.setText("");
    }

}
