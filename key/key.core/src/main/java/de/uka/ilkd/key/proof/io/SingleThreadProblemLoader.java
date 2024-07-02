This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.proof.io;

import java.io.File;
import java.util.List;
import java.util.Properties;

import de.uka.ilkd.key.control.UserInterfaceControl;
import de.uka.ilkd.key.proof.Proof;
import de.uka.ilkd.key.proof.init.InitConfig;
import de.uka.ilkd.key.proof.init.Profile;

/**
 * This single threaded problem loader is used by the Eclipse integration of KeY.
 *
 * @author Martin Hentschel
 */
public class SingleThreadProblemLoader extends AbstractProblemLoader {
    /**
     * Constructor.
     *
     * @param file The file or folder to load.
     * @param classPath The optional class path entries to use.
     * @param bootClassPath An optional boot class path.
     * @param includes Optional includes to consider.
     * @param profileOfNewProofs The {@link Profile} to use for new {@link Proof}s.
     * @param forceNewProfileOfNewProofs {@code} true
     *        {@link AbstractProblemLoader#profileOfNewProofs} will be used as
     *        {@link Profile} of new proofs, {@code false} {@link Profile}
     *        specified by problem file will be used for new proofs.
     * @param control The {@link ProblemLoaderControl} to use.
     * @param askUiToSelectAProofObligationIfNotDefinedByLoadedFile {@code true} to call
     *        {@link UserInterfaceControl#selectProofObligation(InitConfig)} if no {@link Proof} is
     *        defined by the loaded proof or {@code false} otherwise which still allows to work with
     *        the loaded {@link InitConfig}.
     */
    public SingleThreadProblemLoader(File file,
            List<File> classPath,
            File bootClassPath,
            List<File> includes,
            Profile profileOfNewProofs,
            boolean forceNewProfileOfNewProofs,
            ProblemLoaderControl control,
            boolean askUiToSelectAProofObligationIfNotDefinedByLoadedFile,
            Properties poPropertiesToForce) {
        super(file, classPath, bootClassPath, includes, profileOfNewProofs,
            forceNewProfileOfNewProofs, control,
            askUiToSelectAProofObligationIfNotDefinedByLoadedFile, poPropertiesToForce);
    }
}
