This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.informationflow.rule.tacletbuilder;

import de.uka.ilkd.key.informationflow.po.IFProofObligationVars;
import de.uka.ilkd.key.informationflow.po.snippet.InfFlowPOSnippetFactory;
import de.uka.ilkd.key.informationflow.po.snippet.POSnippetFactory;
import de.uka.ilkd.key.java.Services;
import de.uka.ilkd.key.logic.Name;
import de.uka.ilkd.key.logic.Term;
import de.uka.ilkd.key.speclang.InformationFlowContract;
import de.uka.ilkd.key.util.MiscTools;


/**
 *
 * @author christoph
 */
public class MethodInfFlowUnfoldTacletBuilder extends AbstractInfFlowUnfoldTacletBuilder {

    private InformationFlowContract contract;


    public MethodInfFlowUnfoldTacletBuilder(Services services) {
        super(services);
    }


    public void setContract(InformationFlowContract c) {
        this.contract = c;
    }


    @Override
    Name getTacletName() {
        return MiscTools.toValidTacletName(UNFOLD + unfoldCounter + " of " +
            contract.getTarget().getUniqueName());
    }


    @Override
    Term createFindTerm(IFProofObligationVars ifVars) {
        InfFlowPOSnippetFactory f =
            POSnippetFactory.getInfFlowFactory(contract,
                ifVars.c1, ifVars.c2,
                services);
        return f.create(InfFlowPOSnippetFactory.Snippet.SELFCOMPOSED_EXECUTION_WITH_PRE_RELATION);
    }
}
