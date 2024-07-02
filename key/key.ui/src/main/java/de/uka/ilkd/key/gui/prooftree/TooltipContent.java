This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.gui.prooftree;

import de.uka.ilkd.key.pp.LogicPrinter;

public class TooltipContent {
    public String title = "";
    public String notes = "";
    public String additionalInfo = "";

    public String render() {
        if (title.isEmpty() && notes.isEmpty() && additionalInfo.isEmpty()) {
            return title;
        }
        var result = new StringBuilder();
        result.append(title);
        if (!notes.isEmpty()) {
            result.append("<hr>");
            result.append("<b>Notes:</b> ");
            result.append(LogicPrinter.escapeHTML(notes, true));
        }
        if (!additionalInfo.isEmpty()) {
            result.append("<hr>");
            result.append(LogicPrinter.escapeHTML(additionalInfo, true));
        }
        return result.toString();
    }
}
