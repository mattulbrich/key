This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.macros.scripts;

import java.util.HashMap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Alexander Weigl
 * @version 1 (17.10.19)
 */
public class SMTCommandTest {
    @Test
    public void testInstantiation() throws Exception {
        HashMap<String, String> args = new HashMap<>();
        args.put("solver", "z3");

        SMTCommand cmd = new SMTCommand();
        SMTCommand.SMTCommandArguments o = cmd.evaluateArguments(new EngineState(null), args);
        Assertions.assertEquals("z3", o.solver);
    }
}
