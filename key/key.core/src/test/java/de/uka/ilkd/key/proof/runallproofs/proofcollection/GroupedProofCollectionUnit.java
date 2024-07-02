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
import java.util.List;

import de.uka.ilkd.key.proof.runallproofs.RunAllProofsTestUnit;

/**
 * A {@link ProofCollectionUnit} that is created from several {@link TestFile}s
 * that are grouped together.
 *
 * @author Kai Wallisch <kai.wallisch@ira.uka.de>
 */
public class GroupedProofCollectionUnit extends ProofCollectionUnit {

    private static final long serialVersionUID = 1L;
    private final String groupName;
    private final List<TestFile> testFiles;
    private final ProofCollectionSettings settings;

    public GroupedProofCollectionUnit(String groupName,
            ProofCollectionSettings settings, List<TestFile> files) {
        this.groupName = groupName;
        this.settings = settings;
        this.testFiles = files;
    }

    @Override
    public RunAllProofsTestUnit createRunAllProofsTestUnit(String testName)
            throws IOException {
        return new RunAllProofsTestUnit(testName, settings, testFiles, false);
    }

    @Override
    String getName() {
        return groupName;
    }
}
