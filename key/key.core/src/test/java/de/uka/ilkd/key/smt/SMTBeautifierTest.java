This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.smt;

import java.io.IOException;
import java.util.stream.Stream;

import org.key_project.util.Streams;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SMTBeautifierTest {
    public static Stream<Arguments> parameters() throws IOException {
        final var r1 = SMTBeautifierTest.class.getResourceAsStream("beautifier.in.smt2");
        final var r2 = SMTBeautifierTest.class.getResourceAsStream("beautifier.out.smt2");

        Assumptions.assumeTrue(r1 != null);
        Assumptions.assumeTrue(r2 != null);

        String[] smt = Streams.toString(r1).split("; *----+");
        String[] expected = Streams.toString(r2).split("; *----+");
        assertEquals(smt.length, expected.length, "The two files must have same number of clauses");
        var b = Stream.<Arguments>builder();
        for (int i = 0; i < smt.length; i++) {
            b.add(Arguments.of(smt[i], expected[i]));
        }
        return b.build();
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void testSMTBeautifier(String smt, String expected) {
        assertEquals(expected.trim(), SMTBeautifier.indent(smt, 80).trim());
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void testIdemPotent(String smt, String expected) {
        String result1 = SMTBeautifier.indent(smt, 80).trim();
        String result2 = SMTBeautifier.indent(result1, 80).trim();
        assertEquals(result1, result2);
    }
}
