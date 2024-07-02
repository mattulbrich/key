This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package org.key_project.exploration.actions;

import java.awt.event.ActionEvent;

import de.uka.ilkd.key.gui.MainWindow;
import de.uka.ilkd.key.logic.PosInOccurrence;
import de.uka.ilkd.key.logic.SequentFormula;
import de.uka.ilkd.key.logic.Term;
import de.uka.ilkd.key.logic.TermBuilder;
import de.uka.ilkd.key.pp.PosInSequent;
import de.uka.ilkd.key.proof.Goal;
import de.uka.ilkd.key.proof.Node;

import org.key_project.exploration.ProofExplorationService;

/**
 * Action to edit formulas in the actions mode
 *
 * @author Alexander Weigl
 * @author Sarah Grebing
 * @version 2 (25.05.18)
 */
public class EditFormulaAction extends ExplorationAction {
    private final transient PosInSequent posInSeq;

    public EditFormulaAction(PosInSequent pis) {
        this(pis, MainWindow.getInstance());
    }

    public EditFormulaAction(PosInSequent pis, MainWindow mainWindow) {
        super(mainWindow);
        setName("Edit formula");
        this.posInSeq = pis;
        // enable only if position is in sequent
        setEnabled(!pis.isSequent());
    }

    /**
     * If action is chosen in context menu
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (posInSeq.isSequent())
            return;

        TermBuilder tb = getMediator().getServices().getTermBuilder();
        PosInOccurrence pio = posInSeq.getPosInOccurrence();
        Term term = pio.subTerm();
        SequentFormula sf = pio.sequentFormula();
        Goal g = getMediator().getSelectedGoal();
        Term newTerm = promptForTerm(mainWindow, term);

        if (newTerm.equals(term)) {
            return;
        }

        ProofExplorationService api = ProofExplorationService.get(getMediator());
        Node toBeSelected = api.applyChangeFormula(g, pio, sf.formula(),
            tb.replace(sf.formula(), pio.posInTerm(), newTerm));
        getMediator().getSelectionModel().setSelectedNode(toBeSelected);
    }
}
