This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.proof.runallproofs.proofcollection;

import java.io.IOException;
import java.util.Arrays;

import de.uka.ilkd.key.proof.runallproofs.RunAllProofsTestUnit;

/**
 * A {@link ProofCollectionUnit} that is created from a single {@link TestFile}
 * that is not declared as part of a group.
 *
 * @author Kai Wallisch <kai.wallisch@ira.uka.de>
 */
public class SingletonProofCollectionUnit extends ProofCollectionUnit {

    private static final long serialVersionUID = 1L;
    private final TestFile file;
    private final ProofCollectionSettings settings;

    public SingletonProofCollectionUnit(TestFile testFile,
            ProofCollectionSettings settings) {
        this.file = testFile;
        this.settings = settings;
    }

    @Override
    public RunAllProofsTestUnit createRunAllProofsTestUnit(String testName)
            throws IOException {
        return new RunAllProofsTestUnit(testName, settings, Arrays.asList(file), true);
    }

    @Override
    String getName() throws IOException {
        return file.getKeYFile().getName();
    }

}
