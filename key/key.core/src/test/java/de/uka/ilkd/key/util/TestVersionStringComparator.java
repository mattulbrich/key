This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class TestVersionStringComparator {

    @Test
    public void test0() {
        final VersionStringComparator vsc = new VersionStringComparator();
        int r = vsc.compare("1.9.3777", "2.4.0");
        assertTrue(r > 0);
    }

    @Test
    public void test1() {
        final VersionStringComparator vsc = new VersionStringComparator();
        int r = vsc.compare("2.4.0", "2.4.0");
        assertEquals(0, r);
    }

    @Test
    public void test2() {
        final VersionStringComparator vsc = new VersionStringComparator();
        int r = vsc.compare("not a number", "2.4.0");
        assertTrue(r > 0);
    }

    @Test
    public void test3() {
        final VersionStringComparator vsc = new VersionStringComparator();
        int r = vsc.compare("2.4-special", "2.4.1");
        assertTrue(r > 0);
    }

    @Test
    public void test4() {
        final VersionStringComparator vsc = new VersionStringComparator();
        int r = vsc.compare("1-9$3777", "2/4*0");
        assertTrue(r > 0);
    }
}
