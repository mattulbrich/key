This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.macros.scripts;

import java.io.StringReader;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Alexander Weigl
 * @version 1 (7/25/21)
 */
public class ScriptLineParserTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(ScriptLineParserTest.class);

    @Test
    public void test() throws Exception {
        String arg = "macro key1=value1 key2=\"value two\" defval3 \"long defvalue\"; " +
            "command ; \n\n" +
            "# some comment\n" +
            "multiline #comment internal\n command \n with=\"line breaks in \n values\"; \n" +
            "select formula=\"a;b\"; \n" +
            "hyphened-command;\n";

        ScriptLineParser mlp = new ScriptLineParser(new StringReader(arg));
        Map<String, String> str;
        while ((str = mlp.parseCommand()) != null) {
            LOGGER.info(String.valueOf(str));
        }
    }
}
