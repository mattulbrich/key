This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.speclang.jml.pretranslation;

import de.uka.ilkd.key.java.Position;
import de.uka.ilkd.key.speclang.njml.JmlIO;

import org.key_project.util.collection.ImmutableList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class TextualJMLAssertStatementTest {
    private static ImmutableList<TextualJMLConstruct> parseMethodLevel(String ms) {
        return new JmlIO().parseMethodLevel(ms, "test", new Position(0, 0));
    }

    private static void assertTextRepr(String input, String text) {
        var constructs = parseMethodLevel(input);
        assertNotNull(constructs);
        assertEquals(1, constructs.size());
        assertTrue(constructs.head() instanceof TextualJMLAssertStatement);
        var jmlAssert = (TextualJMLAssertStatement) constructs.head();
        var builder = new StringBuilder();
        TextualJMLAssertStatement.ruleContextToText(builder, jmlAssert.getContext().first);
        assertEquals(builder.toString(), text);
    }

    @Test
    public void testTextRepr() {
        assertTextRepr(
            "//@ assert true;",
            "assert true ;");
        assertTextRepr(
            "//@ assert 1 + 2 == 3 && 2 != 3;",
            "assert 1 + 2 == 3 && 2 != 3 ;");
        assertTextRepr(
            "//@ assert (\\forall int j; 0 <= j < 10; true);",
            "assert ( \\forall int j ; 0 <= j < 10 ; true ) ;");
        assertTextRepr(
            "//@ assert (\\forall int j; 0 <= j < 10; (\\exists int k; 0 <= k < 10; j == k));",
            "assert ( \\forall int j ; 0 <= j < 10 ; ( \\exists int k ; 0 <= k < 10 ; j == k ) ) ;");
    }
}
