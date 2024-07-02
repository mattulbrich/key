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
import java.util.EventObject;
import javax.swing.JCheckBoxMenuItem;

import de.uka.ilkd.key.gui.MainWindow;
import de.uka.ilkd.key.settings.ProofIndependentSettings;
import de.uka.ilkd.key.settings.SettingsListener;
import de.uka.ilkd.key.settings.ViewSettings;

/**
 * Toggles the tooltips of the source view.
 *
 * @author Wolfram Pfeifer
 *
 * @see de.uka.ilkd.key.gui.sourceview.SourceView#getToolTipText()
 */
public class ToggleSourceViewTooltipAction extends MainWindowAction {
    /** This action's name. */
    public static final String NAME = "Show Tooltips in Source View";

    /** This action's tooltip. */
    public static final String TOOL_TIP = "If ticked, moving the mouse over a term in the"
        + " source view will show a tooltip with additional information.";

    // private static final long serialVersionUID = -3352122484627890921L;

    /** Listens to changes to the view settings to call {@link #updateSelectedState()}. */
    private final SettingsListener viewSettingsListener = new SettingsListener() {
        @Override
        public void settingsChanged(EventObject e) {
            updateSelectedState();
        }
    };

    /**
     * Create a new action.
     *
     * @param mainWindow the main window.
     */
    public ToggleSourceViewTooltipAction(MainWindow mainWindow) {
        super(mainWindow);
        setName(NAME);
        setTooltip(TOOL_TIP);
        ProofIndependentSettings.DEFAULT_INSTANCE.getViewSettings()
                .addSettingsListener(viewSettingsListener);
        updateSelectedState();
    }

    /**
     * Updates the state of this action according to
     * {@link ViewSettings#isShowSourceViewTooltips()}
     */
    protected void updateSelectedState() {
        final boolean setting = ProofIndependentSettings.DEFAULT_INSTANCE.getViewSettings()
                .isShowSourceViewTooltips();
        setSelected(setting);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean selected = ((JCheckBoxMenuItem) e.getSource()).isSelected();
        ProofIndependentSettings.DEFAULT_INSTANCE.getViewSettings()
                .setShowSourceViewTooltips(selected);
    }
}
