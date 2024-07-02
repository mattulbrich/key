This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.gui.utilities;

import java.awt.Dimension;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

import de.uka.ilkd.key.gui.fonticons.IconFactory;

/**
 * Tab component for {@link JTabbedPane} with a close button.
 *
 * @author lanzinger
 */
public class ClosableTabComponent extends JPanel {

    private static final long serialVersionUID = -7205139488676599833L;

    /**
     * Creates a new {@code ClosableTabComponent}.
     *
     * @param title the component's title.
     * @param closeAction the action to execute when the component is closed.
     */
    public ClosableTabComponent(String title, Action closeAction) {
        setOpaque(false);

        JLabel label = new JLabel(title);
        label.setBackground(UIManager.getColor("TabbedPane.background"));
        add(label);

        JButton button = new JButton(IconFactory.quit(16));
        button.setContentAreaFilled(false);
        button.setPreferredSize(new Dimension(16, 16));
        button.addActionListener(closeAction::actionPerformed);
        add(button);
    }
}
