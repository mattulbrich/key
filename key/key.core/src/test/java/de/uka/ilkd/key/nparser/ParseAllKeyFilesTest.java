This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.nparser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.stream.Collectors;

import de.uka.ilkd.key.util.HelperClassForTests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * @author Alexander Weigl
 * @version 1 (13.09.19)
 */
@Tag("interactive")
@Disabled
public class ParseAllKeyFilesTest {
    public static Collection<Path> getFiles() throws IOException {
        return Files.walk(HelperClassForTests.TESTCASE_DIRECTORY.toPath())
                .filter(file -> Files.isRegularFile(file) && file.toString().endsWith(".key"))
                .collect(Collectors.toList());
    }

    @ParameterizedTest
    @MethodSource("getFiles")
    void parse(Path file) throws IOException {
        KeyAst.File ctx = ParsingFacade.parseFile(file);
        assertNull(ctx.ctx.exception);
    }
}
