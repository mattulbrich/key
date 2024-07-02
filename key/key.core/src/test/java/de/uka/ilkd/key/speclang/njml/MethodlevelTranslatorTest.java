This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.speclang.njml;

import java.io.IOException;
import java.io.InputStream;
import java.util.stream.Stream;

import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * @author Alexander Weigl
 * @version 1 (5/15/20)
 */
public class MethodlevelTranslatorTest {
    @TestFactory
    public Stream<DynamicTest> getFiles() throws IOException {
        InputStream resourceAsStream =
            ExpressionTranslatorTest.class.getResourceAsStream("methodlevel.txt");
        return ClasslevelTranslatorTest.readInputs(resourceAsStream, this::parseAndInterpret);
    }

    public void parseAndInterpret(String expr) {
        assertNotEquals("", expr);
        JmlLexer lexer = JmlFacade.createLexer(expr);
        JmlParser parser = new JmlParser(new CommonTokenStream(lexer));
        try {
            JmlParser.Methodlevel_commentContext ctx = parser.methodlevel_comment();
            if (parser.getNumberOfSyntaxErrors() != 0)
                debugLexer(expr);
        } catch (Exception e) {
            debugLexer(expr);
        }
        assertEquals(0, parser.getNumberOfSyntaxErrors());
    }

    private void debugLexer(String expr) {
        JmlLexer lexer = JmlFacade.createLexer(expr);
        DebugJmlLexer.debug(lexer);
    }
}
