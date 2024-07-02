This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.gui.nodeviews;

import java.util.Collections;
import java.util.List;

import de.uka.ilkd.key.gui.MainWindow;
import de.uka.ilkd.key.gui.extension.api.KeYGuiExtension;
import de.uka.ilkd.key.logic.Term;
import de.uka.ilkd.key.logic.op.ElementaryUpdate;
import de.uka.ilkd.key.pp.PosInSequent;

/**
 * Extension adapter for showing hash codes for terms. Useful for debugging.
 *
 * @author Dominic Steinhoefel
 */
@KeYGuiExtension.Info( //
    name = "Show Hashcodes", //
    optional = true, //
    description = "GUI Extension for showing hash codes in tooltips", //
    experimental = false)
public class ShowHashcodesExtension implements KeYGuiExtension, KeYGuiExtension.Tooltip {

    @Override
    public List<String> getTooltipStrings(MainWindow mainWindow, PosInSequent pos) {
        if (pos == null || pos.isSequent()) {
            return Collections.emptyList();
        }

        String result = "";

        final Term term = pos.getPosInOccurrence().subTerm();
        result += "<b>Operator Hash:</b> " + term.op().hashCode();

        if (term.op() instanceof ElementaryUpdate) {
            result += "<br><b>LHS Hash:</b> " + ((ElementaryUpdate) term.op()).lhs().hashCode();
            result += "<br><b>LHS Sort:</b> "
                + ((ElementaryUpdate) term.op()).lhs().sort().toString();
        }

        return Collections.singletonList(result);
    }
}
