This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.gui.proofdiff;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static de.uka.ilkd.key.gui.proofdiff.ProofDifference.Levensthein.calculate;
import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Alexander Weigl
 * @version 1 (24.05.19)
 */
public class ProofDifferenceTest {

    @Test
    public void testLevensthein() {
        assertEquals(0, calculate("abc", "abc"));

        assertEquals(1, calculate("!p", "p"));

        assertEquals(3, calculate("f(x)", "f(g(x))"));

        assertEquals(4, calculate("f(x)", ""));
    }

    public void testPairs(List<String> seq1, List<String> seq2, String exp) {
        List<ProofDifference.Matching> pairs = ProofDifference.findPairs(
            new ArrayList<>(seq1),
            new ArrayList<>(seq2));
        Assertions.assertEquals(exp, pairs.toString());
    }

    @Test
    public void testPairs1() {
        testPairs(asList("a", "b", "c"), asList("a", "b", "c"),
            "[(a, a), (b, b), (c, c)]");

        testPairs(asList("d", "b", "c"), asList("a", "b", "c"),
            "[(b, b), (c, c), (d, a)]");

        testPairs(asList("p->q", "!q", "p"), asList("p", "p->!q", "!p"),
            "[(p, p), (p->q, p->!q), (!q, !p)]");
    }
}
