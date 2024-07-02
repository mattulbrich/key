This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.proof.runallproofs;

import java.io.Serializable;

/**
 * Data structure for RunAllProofs test results consisting of a string message
 * and a boolean value which specifies whether a test run was successful or not.
 */
public class TestResult implements Serializable {
    private static final long serialVersionUID = 7635762713077999920L;

    public final String message;
    public final boolean success;

    public TestResult(String message, boolean success) {
        this.message = message;
        this.success = success;
    }
}
