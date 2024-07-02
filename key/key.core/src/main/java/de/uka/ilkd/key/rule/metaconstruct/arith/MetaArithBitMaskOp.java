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

import de.uka.ilkd.key.java.Services;
import de.uka.ilkd.key.logic.Name;
import de.uka.ilkd.key.logic.Term;
import de.uka.ilkd.key.logic.op.AbstractTermTransformer;
import de.uka.ilkd.key.rule.inst.SVInstantiations;

public abstract class MetaArithBitMaskOp extends AbstractTermTransformer {

    public MetaArithBitMaskOp(Name name) {
        super(name, 2);
    }

    protected abstract BigInteger bitmaskOp(BigInteger left, BigInteger right);

    public Term transform(Term term, SVInstantiations svInst, Services services) {
        Term arg1 = term.sub(0);
        Term arg2 = term.sub(1);
        BigInteger left;
        BigInteger right;

        left = new BigInteger(convertToDecimalString(arg1, services));
        right = new BigInteger(convertToDecimalString(arg2, services));

        BigInteger result = bitmaskOp(left, right);

        return services.getTermBuilder().zTerm(result.toString());
    }
}
