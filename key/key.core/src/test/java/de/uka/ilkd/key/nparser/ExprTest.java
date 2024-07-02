This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.nparser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import de.uka.ilkd.key.java.Services;
import de.uka.ilkd.key.logic.Term;
import de.uka.ilkd.key.proof.init.JavaProfile;
import de.uka.ilkd.key.util.parsing.BuildingException;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author Alexander Weigl
 * @version 1 (17.10.19)
 */
public class ExprTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExprTest.class);

    @ParameterizedTest
    @CsvFileSource(resources = "exprs.txt", delimiter = '^')
    public void parseAndVisit(String expr) throws IOException {
        Assumptions.assumeFalse(expr.startsWith("#"));
        KeyIO io = getIo();
        try {
            Term actual = io.parseExpression(expr);
            assertNotNull(actual);
            LOGGER.info("Term: {}", actual);
        } catch (BuildingException e) {
            DebugKeyLexer.debug(expr);
        }
    }

    private KeyIO getIo() throws IOException {
        Services services = new Services(new JavaProfile());
        String p = "/de/uka/ilkd/key/proof/rules/ldt.key";
        URL url = getClass().getResource(p);
        Assumptions.assumeTrue(url != null);
        KeyIO io = new KeyIO(services);
        io.load(url).parseFile()
                .loadDeclarations()
                .loadSndDegreeDeclarations();

        NamespaceBuilder nssb = new NamespaceBuilder(services.getNamespaces());
        nssb.addVariable("aa", "int")
                .addVariable("bb", "int")
                .addVariable("cc", "int")
                .addProgramVariable("int", "x");

        // Without this call, the LDTs are not available to the expression
        // builder. Probably a problem of the mocking here. (MU)
        services.getTypeConverter().init();

        return io;
    }
}
