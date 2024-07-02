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
 *
 * @author christoph
 */
class BasicLoopExecutionWithInvariantSnippet extends ReplaceAndRegisterMethod
        implements FactoryMethod {

    @Override
    public Term produce(BasicSnippetData d,
            ProofObligationVars poVars)
            throws UnsupportedOperationException {
        // generate snippet factory for symbolic execution
        BasicPOSnippetFactory symbExecFactory =
            POSnippetFactory.getBasicFactory(d, poVars);

        // loop invariant
        final Term freeInv =
            symbExecFactory.create(BasicPOSnippetFactory.Snippet.FREE_INV);
        final Term loopInv =
            symbExecFactory.create(BasicPOSnippetFactory.Snippet.LOOP_INV);
        final Term inv = d.tb.and(freeInv, loopInv);

        // symbolic execution
        Term symExec =
            symbExecFactory.create(BasicPOSnippetFactory.Snippet.LOOP_EXEC);


        // final symbolic execution term
        return d.tb.and(inv, symExec);
    }

}
