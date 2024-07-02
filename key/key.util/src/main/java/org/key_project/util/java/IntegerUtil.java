This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package org.key_project.util.java;

public final class IntegerUtil {
    /**
     * Forbid instances.
     */
    private IntegerUtil() {
    }

    /**
     * Computes the factorial value of n.
     *
     * @param n The value.
     * @return The computed factorial value or {@code -1} if n is negative.
     */
    public static int factorial(int n) {
        if (n < 0) {
            return -1;
        } else {
            int factorial = 1;
            for (int i = 1; i <= n; i++) {
                factorial *= i;
            }
            return factorial;
        }
    }
}
