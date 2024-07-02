This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.proof.runallproofs;

import java.io.File;
import java.io.Serializable;
import java.util.Date;

import org.key_project.util.helper.FindResources;

/**
 * Initialising directories for runallproofs is a bit tricky since doing it
 * statically results easily in hard-to-detect bugs for forked mode of
 * runallproofs. Subprocesses have to re-initialise static variables correctly,
 * which could be overlooked or implemented incorrectly. Even if implemented
 * correctly, the resulting code can be quite complicated.
 * <p>
 * An alternative is to pass-through pointers non-statically to the places where
 * they are needed. This again results results in inconvenient clutter in the
 * code.
 * <p>
 * I eventually decided to put all filesystem-related stuff from runallproofs to
 * a separate location.
 *
 * @author kai
 */
@SuppressWarnings("serial")
public class RunAllProofsDirectories implements Serializable {
    public static final File EXAMPLE_DIR = FindResources.getExampleDirectory();
    public static final File RUNALLPROOFS_DIR = FindResources.getTestResultForRunAllProofs();

    public RunAllProofsDirectories(Date runStart) {
        RUNALLPROOFS_DIR.mkdirs();
    }

}
