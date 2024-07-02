This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.suite.util;

import java.io.File;

import org.key_project.util.helper.FindResources;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class HelperClassForTestgenTests {
    public static final File TESTCASE_DIRECTORY = FindResources.getTestCasesDirectory();

    static {
        assertNotNull(TESTCASE_DIRECTORY, "Could not find test case directory");
    }
}
