This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.speclang;

import java.util.function.UnaryOperator;

import de.uka.ilkd.key.java.Services;
import de.uka.ilkd.key.java.abstraction.KeYJavaType;
import de.uka.ilkd.key.logic.Term;
import de.uka.ilkd.key.logic.op.IObserverFunction;
import de.uka.ilkd.key.proof.init.ContractPO;
import de.uka.ilkd.key.proof.init.FunctionalLoopContractPO;
import de.uka.ilkd.key.proof.init.InitConfig;
import de.uka.ilkd.key.proof.init.ProofOblInput;

/**
 * This class is only used to generate a proof obligation for a block that starts with a loop (see
 * {@link FunctionalLoopContractPO}.
 *
 * If a block is encountered during a proof, {@link LoopContract} is used instead.
 *
 * @author lanzinger
 */
public class FunctionalLoopContract extends FunctionalAuxiliaryContract<LoopContract> {

    /**
     *
     * @param contract
     *        a loop contract.
     */
    FunctionalLoopContract(LoopContract contract) {
        super(contract);
    }

    /**
     *
     * @param contract
     *        a loop contract.
     * @param id
     *        an ID.
     */
    FunctionalLoopContract(LoopContract contract, int id) {
        super(contract, id);
    }

    @Override
    public FunctionalLoopContract map(UnaryOperator<Term> op, Services services) {
        return new FunctionalLoopContract(getAuxiliaryContract().map(op, services), id());
    }

    @Override
    public ContractPO createProofObl(InitConfig initConfig) {
        return new FunctionalLoopContractPO(initConfig, this);
    }

    @Override
    public ProofOblInput createProofObl(InitConfig initConfig, Contract contract) {
        assert contract instanceof FunctionalLoopContract;
        return new FunctionalLoopContractPO(initConfig, (FunctionalLoopContract) contract);
    }

    @Override
    public ProofOblInput createProofObl(InitConfig initConfig, Contract contract,
            boolean supportSymbolicExecutionAPI) {
        return createProofObl(initConfig, contract);
    }

    @Override
    public Contract setID(int newId) {
        return new FunctionalLoopContract(getAuxiliaryContract(), newId);
    }

    @Override
    public Contract setTarget(KeYJavaType newKJT, IObserverFunction newPM) {
        return new FunctionalLoopContract(getAuxiliaryContract().setTarget(newKJT, newPM), id());
    }

    /**
     * Replaces {@code \index} and {@code \values} with the proper variables in all terms of this
     * contract.
     *
     * @param services services.
     *
     * @see LoopContract#replaceEnhancedForVariables(de.uka.ilkd.key.java.StatementBlock, Services)
     */
    public void replaceEnhancedForVariables(Services services) {
        setAuxiliaryContract(
            getAuxiliaryContract().replaceEnhancedForVariables(
                getAuxiliaryContract().getBlock(), services));
    }
}
