This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.gui.originlabels;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

import de.uka.ilkd.key.gui.MainWindow;
import de.uka.ilkd.key.gui.actions.MainWindowAction;
import de.uka.ilkd.key.logic.PosInOccurrence;
import de.uka.ilkd.key.logic.sort.Sort;
import de.uka.ilkd.key.pp.PosInSequent;
import de.uka.ilkd.key.settings.ProofIndependentSettings;
import de.uka.ilkd.key.settings.TermLabelSettings;

/**
 * Opens a {@link OriginTermLabelVisualizer} for the selected term.
 *
 * @author lanzinger
 */
public class ShowOriginAction extends MainWindowAction {

    private static final long serialVersionUID = 4557953425770258852L;

    private PosInSequent pos;

    /**
     * Creates a new {@link ShowOriginAction}.
     *
     * @param pos the position of the term whose origin shall be shown.
     */
    public ShowOriginAction(PosInSequent pos) {
        super(MainWindow.getInstance());
        this.pos = pos == null ? PosInSequent.createSequentPos() : pos;

        final TermLabelSettings settings =
            ProofIndependentSettings.DEFAULT_INSTANCE.getTermLabelSettings();

        setName("Show origin");
        setEnabled(settings.getUseOriginLabels());
        settings.addSettingsListener(event -> setEnabled(settings.getUseOriginLabels()));
        setMenuPath("View");
        lookupAcceleratorKey();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        PosInOccurrence pio = pos.getPosInOccurrence();

        // OriginTermLabelVisualizer.TermView can only print sequents or formulas, not terms.
        if (pio != null) {
            while (!pio.subTerm().sort().equals(Sort.FORMULA)) {
                pio = pio.up();
            }
        }

        OriginTermLabelVisualizer vis = new OriginTermLabelVisualizer(
            pio,
            getMediator().getSelectedNode(),
            getMediator().getServices());

        mainWindow.getSourceViewFrame().addComponent(
            vis,
            vis.getLongName(),
            new AbstractAction() {

                private static final long serialVersionUID = 2410334588447893970L;

                @Override
                public void actionPerformed(ActionEvent e) {
                    mainWindow.getSourceViewFrame().removeComponent(vis);
                    vis.dispose();
                }
            });
    }
}
