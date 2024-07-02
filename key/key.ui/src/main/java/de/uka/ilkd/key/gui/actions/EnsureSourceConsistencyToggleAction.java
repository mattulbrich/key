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
import javax.swing.JOptionPane;

import de.uka.ilkd.key.gui.MainWindow;
import de.uka.ilkd.key.settings.ProofIndependentSettings;

/**
 * Toggles the flag to ensure consistency between source code and saved proof. Consistency is
 * ensured by caching the source files at first use via a FileRepo.
 *
 * @author Wolfram Pfeifer
 */
public class EnsureSourceConsistencyToggleAction extends MainWindowAction {

    private static final long serialVersionUID = -6884872135310450140L;

    /**
     * Creates a new EnsureSourceConsistencyToggleAction.
     *
     * @param mainWindow the main window of the program
     */
    public EnsureSourceConsistencyToggleAction(MainWindow mainWindow) {
        super(mainWindow);
        setName("Ensure Source Consistency");
        setTooltip("If ticked, consistency between source and proof is ensured"
            + " (by caching files at first use in a temporary directory).");
        setSelected(ProofIndependentSettings.DEFAULT_INSTANCE
                .getGeneralSettings()
                .isEnsureSourceConsistency());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // changes become effective for the next proof
        if (mainWindow.getMediator().ensureProofLoaded()) {
            JOptionPane.showMessageDialog(mainWindow,
                "Your changes will become effective when the next problem is loaded.\n",
                "Allow Proof Bundle Saving", JOptionPane.INFORMATION_MESSAGE);
        }
        boolean selected = isSelected();
        ProofIndependentSettings.DEFAULT_INSTANCE
                .getGeneralSettings()
                .setEnsureSourceConsistency(selected);
    }
}
