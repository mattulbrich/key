This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.informationflow.po.snippet;

import de.uka.ilkd.key.logic.Term;
import de.uka.ilkd.key.logic.op.IObserverFunction;
import de.uka.ilkd.key.logic.op.IProgramMethod;
import de.uka.ilkd.key.proof.init.ProofObligationVars;

/**
 * Generate term "self != null".
 *
 * @author christoph
 */
class BasicSelfNotNullSnippet implements FactoryMethod {

    @Override
    public Term produce(BasicSnippetData d,
            ProofObligationVars poVars)
            throws UnsupportedOperationException {
        IObserverFunction targetMethod =
            (IObserverFunction) d.get(BasicSnippetData.Key.TARGET_METHOD);
        if (!(targetMethod instanceof IProgramMethod)) {
            throw new UnsupportedOperationException("Tried to produce "
                + "SELF_NOT_NULL for an observer "
                + "which is no IProgramMethod.");
        }
        final IProgramMethod pm = (IProgramMethod) targetMethod;
        return (poVars.pre.self == null || pm.isConstructor())
                ? d.tb.tt()
                : d.tb.not(d.tb.equals(poVars.pre.self, d.tb.NULL()));
    }
}
