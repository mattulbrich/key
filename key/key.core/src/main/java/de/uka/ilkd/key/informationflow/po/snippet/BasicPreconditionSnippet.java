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
import de.uka.ilkd.key.proof.init.ProofObligationVars;

/**
 * Generate term "self != null".
 *
 * @author christoph
 */
class BasicPreconditionSnippet extends ReplaceAndRegisterMethod implements FactoryMethod {

    @Override
    public Term produce(BasicSnippetData d,
            ProofObligationVars poVars)
            throws UnsupportedOperationException {
        if (d.get(BasicSnippetData.Key.PRECONDITION) == null) {
            throw new UnsupportedOperationException("Tried to produce a "
                + "precondition for a contract without precondition.");
        }
        assert Term.class.equals(BasicSnippetData.Key.PRECONDITION.getType());
        Term origPre = (Term) d.get(
            BasicSnippetData.Key.PRECONDITION);
        return replace(origPre, d.origVars, poVars.pre, d.tb);
    }
}
