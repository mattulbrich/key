This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.gui;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Alexander Weigl
 * @version 1 (30.05.19)
 */
public class KeyboardTacletTest {

    @Test
    public void prefixTest() {
        assertEquals(3, KeyboardTacletModel.getPrefixLength("andLeft", "andRight"));
        assertEquals(3, KeyboardTacletModel.getPrefixLength("cut", "cut_direct"));
        assertEquals(0, KeyboardTacletModel.getPrefixLength("andLeft", "impRight"));


        List<String> keywords =
            Arrays.asList("cut", "cut_direct", "andLeft", "andRight", "impRight");

        assertEquals(3, KeyboardTacletModel.getClashFreePrefix("impLeft", keywords));

        Map<String, String> table = KeyboardTacletModel.buildPrefixTable(keywords);
        List<String> prefixes = table.keySet().stream().sorted().collect(Collectors.toList());
        assertEquals("[andL, andR, cut, cut_, i]", prefixes.toString());
    }
}
