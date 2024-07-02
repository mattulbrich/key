This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.informationflow.po.snippet;

import de.uka.ilkd.key.java.Services;
import de.uka.ilkd.key.java.reference.ExecutionContext;
import de.uka.ilkd.key.logic.Term;
import de.uka.ilkd.key.proof.init.ProofObligationVars;
import de.uka.ilkd.key.speclang.BlockContract;
import de.uka.ilkd.key.speclang.FunctionalOperationContract;
import de.uka.ilkd.key.speclang.InformationFlowContract;
import de.uka.ilkd.key.speclang.LoopSpecification;


/**
 *
 * @author christoph
 */
public class POSnippetFactory {

    public static BasicPOSnippetFactory getBasicFactory(
            FunctionalOperationContract contract,
            ProofObligationVars vars,
            Services services) {
        return new BasicPOSnippetFactoryImpl(contract, vars, services);
    }

    public static BasicPOSnippetFactory getBasicFactory(
            LoopSpecification invariant,
            ProofObligationVars vars,
            ExecutionContext context,
            Term guardTerm,
            Services services) {
        return new BasicPOSnippetFactoryImpl(invariant, vars, context,
            guardTerm, services);
    }

    public static BasicPOSnippetFactory getBasicFactory(
            InformationFlowContract contract,
            ProofObligationVars vars,
            Services services) {
        return new BasicPOSnippetFactoryImpl(contract, vars, services);
    }

    public static BasicPOSnippetFactory getBasicFactory(
            BlockContract contract,
            ProofObligationVars vars,
            ExecutionContext context,
            Services services) {
        return new BasicPOSnippetFactoryImpl(contract, vars, context, services);
    }

    static BasicPOSnippetFactory getBasicFactory(
            BasicSnippetData data,
            ProofObligationVars poVars) {
        return new BasicPOSnippetFactoryImpl(data, poVars);
    }

    public static InfFlowPOSnippetFactory getInfFlowFactory(
            LoopSpecification invariant,
            ProofObligationVars vars1,
            ProofObligationVars vars2,
            ExecutionContext context,
            Term guardTerm,
            Services services) {
        return new InfFlowPOSnippetFactoryImpl(invariant, vars1, vars2, context,
            guardTerm, services);
    }

    public static InfFlowPOSnippetFactory getInfFlowFactory(
            InformationFlowContract contract,
            ProofObligationVars vars1,
            ProofObligationVars vars2,
            Services services) {
        return new InfFlowPOSnippetFactoryImpl(contract, vars1, vars2, services);
    }

    public static InfFlowPOSnippetFactory getInfFlowFactory(
            BlockContract contract,
            ProofObligationVars vars1,
            ProofObligationVars vars2,
            ExecutionContext context,
            Services services) {
        return new InfFlowPOSnippetFactoryImpl(contract, vars1, vars2,
            context, services);
    }

    static InfFlowPOSnippetFactory getInfFlowFactory(
            BasicSnippetData data,
            ProofObligationVars vars1,
            ProofObligationVars vars2) {
        return new InfFlowPOSnippetFactoryImpl(data, vars1, vars2);
    }
}
