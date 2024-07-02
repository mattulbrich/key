This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.speclang.njml;

import java.io.File;

import de.uka.ilkd.key.api.KeYApi;
import de.uka.ilkd.key.api.ProofManagementApi;
import de.uka.ilkd.key.java.Services;
import de.uka.ilkd.key.proof.io.ProblemLoaderException;
import de.uka.ilkd.key.speclang.Contract;
import de.uka.ilkd.key.util.HelperClassForTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ContractLoadingTests {
    public static final File EXAMPLES_DIR = new File("../key.ui/examples/");

    @Test
    public void sumAndMax() throws ProblemLoaderException {
        final File javaFile =
            new File(EXAMPLES_DIR, "heap/vstte10_01_SumAndMax/src/SumAndMax.java");
        ProofManagementApi file = KeYApi.loadProof(javaFile);
        Services services = file.getServices();
        Logger LOGGER = LoggerFactory.getLogger(ContractLoadingTests.class);
        for (Contract proofContract : file.getProofContracts()) {
            LOGGER.info(proofContract.getPlainText(services));
        }
    }

    @Test
    public void issues1658() throws ProblemLoaderException {
        final File javaFile =
            new File(HelperClassForTests.TESTCASE_DIRECTORY, "issues/1658/Test.java");
        Assumptions.assumeTrue(javaFile.exists());
        ProofManagementApi file = KeYApi.loadProof(javaFile);
        Assertions.assertTrue(file.getProofContracts().size() > 0);
    }
}
