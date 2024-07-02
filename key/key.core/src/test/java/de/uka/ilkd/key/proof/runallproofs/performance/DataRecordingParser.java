This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.proof.runallproofs.performance;

import de.uka.ilkd.key.proof.runallproofs.proofcollection.ProofCollectionParser;
import de.uka.ilkd.key.proof.runallproofs.proofcollection.ProofCollectionSettings;
import de.uka.ilkd.key.proof.runallproofs.proofcollection.TestProperty;

import org.antlr.runtime.TokenStream;

public class DataRecordingParser extends ProofCollectionParser {

    public DataRecordingParser(TokenStream input) {
        super(input);
    }

    @Override
    public DataRecordingTestFile getTestFile(TestProperty testProperty, String path,
            ProofCollectionSettings settings) {
        return new DataRecordingTestFile(testProperty, path, settings);
    }
}
