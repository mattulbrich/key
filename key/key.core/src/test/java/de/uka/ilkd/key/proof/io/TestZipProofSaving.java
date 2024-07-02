This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.proof.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import de.uka.ilkd.key.control.DefaultUserInterfaceControl;
import de.uka.ilkd.key.control.KeYEnvironment;

import org.junit.jupiter.api.Test;

public class TestZipProofSaving {

    @Test
    public void testZip() throws Exception {

        Path file = Files.createTempFile("keyZipTest", ".key");
        Path fileTarget = Files.createTempFile("keyZipTest", ".proof.gz");
        drain(getClass().getResourceAsStream("keyZipTest.key"), Files.newOutputStream(file));
        proveAndSaveZip(file, fileTarget);

        loadZip(fileTarget);
    }

    private void loadZip(Path fileTarget) throws Exception {
        KeYEnvironment<DefaultUserInterfaceControl> env = KeYEnvironment.load(fileTarget.toFile());
        env.getProofControl().startAndWaitForAutoMode(env.getLoadedProof());
    }

    private void proveAndSaveZip(Path file, Path fileTarget)
            throws ProblemLoaderException, IOException {
        KeYEnvironment<DefaultUserInterfaceControl> env = KeYEnvironment.load(file.toFile());
        env.getProofControl().startAndWaitForAutoMode(env.getLoadedProof());
        GZipProofSaver proofSaver =
            new GZipProofSaver(env.getLoadedProof(), fileTarget.toString(), "n/a");
        proofSaver.save();
    }

    private void drain(InputStream is, OutputStream os) throws IOException {
        try {
            byte[] buffer = new byte[4096];
            int read = is.read(buffer);
            while (read >= 0) {
                os.write(buffer, 0, read);
                read = is.read(buffer);
            }
        } finally {
            if (is != null) {
                is.close();
            }
            if (os != null) {
                os.close();
            }
        }
    }

}
