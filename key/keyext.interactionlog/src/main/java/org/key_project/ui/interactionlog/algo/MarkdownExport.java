This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package org.key_project.ui.interactionlog.algo;

import java.io.PrintWriter;

import org.key_project.ui.interactionlog.api.Interaction;
import org.key_project.ui.interactionlog.api.Markdownable;
import org.key_project.ui.interactionlog.model.InteractionLog;
import org.key_project.ui.markdown.Markdown;

public class MarkdownExport {
    private final PrintWriter writer;

    public MarkdownExport(PrintWriter writer) {
        this.writer = writer;
    }

    public static void writeTo(InteractionLog logbook, PrintWriter writer) {
        MarkdownExport me = new MarkdownExport(writer);
        writer.format("# Log book *%s*%n%n", logbook.getName());
        writer.format("Created at *%s*%n%n", logbook.getCreated());
        logbook.getInteractions().forEach(it -> writer.format(getMarkdown(it) + "\n"));
    }

    public static String getMarkdown(Interaction interaction) {
        try {
            Markdownable m = (Markdownable) interaction;
            return m.getMarkdown();
        } catch (ClassCastException e) {
        }
        return "";
    }

    public static String getHtml(Interaction inter) {
        return Markdown.html(getMarkdown(inter));
    }
}
