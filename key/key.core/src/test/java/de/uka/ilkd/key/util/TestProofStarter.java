This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.util;

import java.io.File;

import de.uka.ilkd.key.control.DefaultUserInterfaceControl;
import de.uka.ilkd.key.control.KeYEnvironment;
import de.uka.ilkd.key.proof.Proof;
import de.uka.ilkd.key.proof.io.ProblemLoaderException;
import de.uka.ilkd.key.prover.impl.ApplyStrategyInfo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests for {@link ProofStarter}.
 *
 * @author Martin Hentschel
 */
public class TestProofStarter {
    /**
     * Loads key-file {@code examples/_testcase/proofStarter/CC/project.key}
     * and runs the auto mode via {@link ProofStarter}
     * while one step simplification is disabled.
     *
     * @throws ProblemLoaderException Occurred Exception
     */
    @Test()
    @Timeout(60000)
    public void testDirectProof() throws ProblemLoaderException {
        doProofStarter(false);
    }

    /**
     * Loads key-file {@code examples/_testcase/proofStarter/CC/project.key}
     * and runs the auto mode via {@link ProofStarter}
     * while one step simplification is enabled.
     *
     * @throws ProblemLoaderException Occurred Exception
     */
    @Test
    @Timeout(120000)
    public void testDirectProofWithOneStepSimplification() throws ProblemLoaderException {
        doProofStarter(true);
    }

    /**
     * Executes the test steps of {@link #testDirectProof()}
     * and {@link #testDirectProofWithOneStepSimplification()}.
     *
     * @param oneStepSimplification Use one step simplification?
     * @throws ProblemLoaderException Occurred Exception
     */
    protected void doProofStarter(boolean oneStepSimplification) throws ProblemLoaderException {
        KeYEnvironment<DefaultUserInterfaceControl> env = null;
        boolean originalOneStepSimplification =
            HelperClassForTests.isOneStepSimplificationEnabled(null);
        try {
            File file =
                new File(HelperClassForTests.TESTCASE_DIRECTORY, "proofStarter/CC/project.key");
            env = KeYEnvironment.load(file, null, null, null);
            Proof proof = env.getLoadedProof();
            assertNotNull(proof);
            ProofStarter ps = new ProofStarter(false);
            ps.init(proof);
            HelperClassForTests.setOneStepSimplificationEnabled(proof, oneStepSimplification);
            ApplyStrategyInfo info = ps.start();
            assertNotNull(info);
            assertTrue(proof.closed());
        } finally {
            HelperClassForTests.setOneStepSimplificationEnabled(null,
                originalOneStepSimplification);
            if (env != null) {
                env.dispose();
            }
        }
    }
}
