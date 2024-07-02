This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.informationflow.po.snippet;

import de.uka.ilkd.key.java.StatementBlock;
import de.uka.ilkd.key.logic.op.IProgramMethod;
import de.uka.ilkd.key.speclang.LoopSpecification;
import de.uka.ilkd.key.util.MiscTools;

public class LoopCallPredicateSnippet extends TwoStateMethodPredicateSnippet {
    @Override
    String generatePredicateName(IProgramMethod pm,
            StatementBlock block,
            LoopSpecification loopInv) {
        final String nameString =
            MiscTools.toValidTacletName("RELATED_BY_LOOP_" + "at_line_" +
                loopInv.getLoop().getStartPosition().getLine() +
                "_in_" + pm.getUniqueName()).toString();
        return nameString;
    }
}
