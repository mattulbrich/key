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