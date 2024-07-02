This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.rule.metaconstruct.arith;

import java.math.BigInteger;

import de.uka.ilkd.key.logic.Name;

public class MetaShiftLeft extends MetaShift {

    public MetaShiftLeft() {
        super(new Name("#ShiftLeft"));
    }

    @Override
    protected BigInteger shiftOp(BigInteger left, BigInteger right) {
        return left.shiftLeft(right.intValue());
    }

}
