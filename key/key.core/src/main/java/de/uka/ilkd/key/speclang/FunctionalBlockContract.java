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
import de.uka.ilkd.key.proof.init.FunctionalBlockContractPO;
import de.uka.ilkd.key.proof.init.InitConfig;
import de.uka.ilkd.key.proof.init.ProofOblInput;

/**
 * This class is only used to generate a proof obligation for a block (see
 * {@link FunctionalBlockContractPO}.
 *
 * If a block is encountered during a proof, {@link BlockContract} is used instead.
 *
 * @author lanzinger
 */
public class FunctionalBlockContract extends FunctionalAuxiliaryContract<BlockContract> {

    /**
     *
     * @param contract
     *        a block contract.
     */
    FunctionalBlockContract(BlockContract contract) {
        super(contract);
    }

    /**
     *
     * @param contract
     *        a block contract.
     * @param id
     *        an ID.
     */
    FunctionalBlockContract(BlockContract contract, int id) {
        super(contract, id);
    }

    @Override
    public FunctionalBlockContract map(UnaryOperator<Term> op, Services services) {
        return new FunctionalBlockContract(getAuxiliaryContract().map(op, services), id());
    }

    @Override
    public ContractPO createProofObl(InitConfig initConfig) {
        return new FunctionalBlockContractPO(initConfig, this);
    }

    @Override
    public ProofOblInput createProofObl(InitConfig initConfig, Contract contract) {
        assert contract instanceof FunctionalBlockContract;
        return new FunctionalBlockContractPO(initConfig, (FunctionalBlockContract) contract);
    }

    @Override
    public ProofOblInput createProofObl(InitConfig initConfig, Contract contract,
            boolean supportSymbolicExecutionAPI) {
        return createProofObl(initConfig, contract);
    }

    @Override
    public Contract setID(int newId) {
        return new FunctionalBlockContract(getAuxiliaryContract(), newId);
    }

    @Override
    public Contract setTarget(KeYJavaType newKJT, IObserverFunction newPM) {
        return new FunctionalBlockContract(getAuxiliaryContract().setTarget(newKJT, newPM), id());
    }
}
