This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.gui.actions;

import java.awt.event.ActionEvent;

import de.uka.ilkd.key.gui.IssueDialog;
import de.uka.ilkd.key.gui.MainWindow;

public class MenuSendFeedackAction extends MainWindowAction {

    private static final long serialVersionUID = 1L;

    public MenuSendFeedackAction(MainWindow mainWindow) {
        super(mainWindow);
        setName("Send Feedback...");
    }

    /**
     * Re-using {@link SendFeedbackAction} from {@link IssueDialog} for this.
     */
    private final SendFeedbackAction action = new SendFeedbackAction(mainWindow);

    @Override
    public void actionPerformed(ActionEvent arg0) {
        action.actionPerformed(arg0);
    }
}
