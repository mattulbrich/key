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
class BasicDependsSnippet extends ReplaceAndRegisterMethod implements FactoryMethod {

    @Override
    public Term produce(BasicSnippetData d,
            ProofObligationVars poVars)
            throws UnsupportedOperationException {
        if (d.get(BasicSnippetData.Key.DEPENDENS) == null) {
            throw new UnsupportedOperationException("Tried to produce a "
                + "depends-term for a contract without dependencies.");
        }
        assert Term.class.equals(BasicSnippetData.Key.DEPENDENS.getType());
        Term origDep = (Term) d.get(BasicSnippetData.Key.DEPENDENS);
        return replace(origDep, d.origVars, poVars.pre, d.tb);
    }
}
