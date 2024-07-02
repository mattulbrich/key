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

import de.uka.ilkd.key.gui.MainWindow;
import de.uka.ilkd.key.settings.ProofIndependentSettings;

import org.key_project.util.java.IOUtil;

public class AutoSave extends MainWindowAction {
    private static final long serialVersionUID = -2598146925208531491L;
    public static final int DEFAULT_PERIOD = 2000;

    public AutoSave(MainWindow mainWindow) {
        super(mainWindow);
        setTooltip("Proofs will be automatically saved to +" + IOUtil.getTempDirectory() +
            "periodically and when finished.");
        setName("Auto Save Proofs");
        setSelected(
            ProofIndependentSettings.DEFAULT_INSTANCE.getGeneralSettings().autoSavePeriod() > 0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int p = isSelected() ? DEFAULT_PERIOD : 0;
        ProofIndependentSettings.DEFAULT_INSTANCE.getGeneralSettings().setAutoSave(p);
        this.getMediator().setAutoSave(p);
    }

}
