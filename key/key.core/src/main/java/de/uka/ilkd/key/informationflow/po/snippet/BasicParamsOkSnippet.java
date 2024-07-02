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
import de.uka.ilkd.key.logic.op.ProgramVariable;
import de.uka.ilkd.key.proof.init.ProofObligationVars;

/**
 * Generate conjunction of...
 * - "p_i.<created> = TRUE | p_i = null" for object parameters, and
 * - "inBounds(p_i)" for integer parameters
 *
 * @author christoph
 */
class BasicParamsOkSnippet implements FactoryMethod {

    @Override
    public Term produce(BasicSnippetData d,
            ProofObligationVars poVars)
            throws UnsupportedOperationException {
        Term paramsOK = d.tb.tt();
        for (Term param : poVars.pre.localVars) {
            if (!(param.op() instanceof ProgramVariable)) {
                throw new UnsupportedOperationException("Tried to produce "
                    + "PARAMS_OK for a term "
                    + "which is no ProgramVariable.");
            }
            ProgramVariable pv = (ProgramVariable) param.op();
            paramsOK = d.tb.and(paramsOK,
                d.tb.reachableValue(poVars.pre.heap, param, pv.getKeYJavaType()));
        }
        if (poVars.pre.guard != null) {
            if (!(poVars.pre.guard.op() instanceof ProgramVariable)) {
                throw new UnsupportedOperationException("Tried to produce "
                    + "PARAMS_OK for a term "
                    + "which is no ProgramVariable.");
            }
            ProgramVariable pv = (ProgramVariable) poVars.pre.guard.op();
            paramsOK = d.tb.and(paramsOK,
                d.tb.reachableValue(poVars.pre.heap, poVars.pre.guard, pv.getKeYJavaType()));
        }
        return paramsOK;
    }
}
