This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.proof.io.consistency;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.Path;
import java.util.List;

import de.uka.ilkd.key.proof.Proof;
import de.uka.ilkd.key.proof.event.ProofDisposedEvent;
import de.uka.ilkd.key.proof.io.RuleSource;

/**
 * This FileRepo does not cache any files but writes to / reads from the original files on disk.
 * It can be used for recreating the old behavior of KeY without a FileRepo.
 *
 * @author Wolfram Pfeifer
 */
public class TrivialFileRepo implements FileRepo {
    @Override
    public InputStream getInputStream(Path path) throws FileNotFoundException, IOException {

        // wrap path into URL for uniform treatment
        return getInputStream(path.toUri().toURL());
    }

    @Override
    public InputStream getInputStream(RuleSource ruleSource) {
        return ruleSource.getNewStream();
    }

    @Override
    public InputStream getInputStream(URL url) throws IOException {
        return url.openStream();
    }

    @Override
    public OutputStream createOutputStream(Path path) throws FileNotFoundException {
        return new FileOutputStream(path.toFile());
    }

    @Override
    public void proofDisposing(ProofDisposedEvent e) {
        // since there are no copies, nothing has to be cleaned
    }

    @Override
    public void proofDisposed(ProofDisposedEvent e) {
        // since there are no copies, nothing has to be cleaned
    }

    @Override
    public void registerProof(Proof proof) {
        // nothing to do here
    }

    @Override
    public void setBootClassPath(File path) throws IllegalStateException {
        // nothing to do here
    }

    @Override
    public void setClassPath(List<File> classPath) throws IllegalStateException {
        // nothing to do here
    }

    @Override
    public void setJavaPath(String javaPath) throws IllegalStateException {
        // nothing to do here
    }

    @Override
    public void setBaseDir(Path path) {
        // nothing to do here
    }
}
