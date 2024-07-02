This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package org.key_project.util.testcase.java;

import org.key_project.util.java.IntegerUtil;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for {@link IntegerUtil}
 *
 * @author Martin Hentschel
 */
public class IntegerUtilTest {
    /**
     * Tests {@link IntegerUtil#factorial(int)}.
     */
    @Test
    public void testFactorial() {
        assertEquals(-1, IntegerUtil.factorial(-3));
        assertEquals(-1, IntegerUtil.factorial(-2));
        assertEquals(-1, IntegerUtil.factorial(-1));
        assertEquals(1, IntegerUtil.factorial(0));
        assertEquals(1, IntegerUtil.factorial(1));
        assertEquals(2, IntegerUtil.factorial(2));
        assertEquals(6, IntegerUtil.factorial(3));
        assertEquals(24, IntegerUtil.factorial(4));
        assertEquals(120, IntegerUtil.factorial(5));
    }
}
