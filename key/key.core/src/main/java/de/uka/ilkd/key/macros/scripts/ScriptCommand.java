This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.macros.scripts;

import java.io.File;
import java.nio.file.NoSuchFileException;

import de.uka.ilkd.key.macros.scripts.meta.Option;

public class ScriptCommand extends AbstractCommand<ScriptCommand.Parameters> {
    public ScriptCommand() {
        super(Parameters.class);
    }

    public static class Parameters {
        @Option("#2")
        public String filename;
    }

    @Override
    public void execute(Parameters args)
            throws ScriptException, InterruptedException {
        File root = state.getBaseFileName();
        if (!root.isDirectory())
            root = root.getParentFile();
        File file = new File(root, args.filename);

        log.info("Included script " + file);

        try {
            ProofScriptEngine pse = new ProofScriptEngine(file);
            pse.setCommandMonitor(state.getObserver());
            pse.execute(uiControl, proof);
        } catch (NoSuchFileException e) {
            // The message is very cryptic otherwise.
            throw new ScriptException("Script file '" + file + "' not found",
                e);
        } catch (Exception e) {
            throw new ScriptException(
                "Error while running script'" + file + "': " + e
                        .getMessage(),
                e);
        }
    }

    @Override
    public String getName() {
        return "script";
    }
}
