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
import java.io.StringWriter;

import org.key_project.ui.interactionlog.api.Interaction;
import org.key_project.ui.interactionlog.model.InteractionLog;
import org.key_project.ui.interactionlog.model.NodeIdentifier;
import org.key_project.ui.interactionlog.model.NodeInteraction;

/**
 * @author Alexander Weigl
 * @version 1 (09.12.18)
 */
public class MUProofScriptExport {
    public static void writeTo(InteractionLog logbook, PrintWriter writer) {
        writer.format("// Proof script: *%s*%n", logbook.getName());
        writer.format("// Created at *%s*%n", logbook.getCreated());
        logbook.getInteractions().forEach(it -> {
            writeSelector(writer, it);
            writer.write(it.getProofScriptRepresentation());
        });
    }

    private static void writeSelector(PrintWriter out, Interaction it) {
        try {
            NodeIdentifier id = ((NodeInteraction) it).getNodeId();
            if (id != null)
                out.format("select %s;%n", id.getBranchLabel());
        } catch (ClassCastException ignored) {
        }
    }

    public static String getScript(InteractionLog current) {
        StringWriter sw = new StringWriter();
        writeTo(current, new PrintWriter(sw));
        return sw.toString();
    }
}
