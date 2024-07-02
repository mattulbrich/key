This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.proof.io.consistency;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.Path;

import de.uka.ilkd.key.proof.io.RuleSource;

/**
 * This class uses the memory as a store for the proof-relevant files.
 *
 * @author Wolfram Pfeifer
 */
public class MemoryFileRepo extends AbstractFileRepo {

    @Override
    public InputStream getInputStream(Path path) throws FileNotFoundException, IOException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public InputStream getInputStream(RuleSource ruleSource) throws IOException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public InputStream getInputStream(URL url) throws IOException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public OutputStream createOutputStream(Path path) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public InputStream getInputStreamInternal(Path p) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Path getSaveName(Path path) {
        // TODO Auto-generated method stub
        return null;
    }
}
