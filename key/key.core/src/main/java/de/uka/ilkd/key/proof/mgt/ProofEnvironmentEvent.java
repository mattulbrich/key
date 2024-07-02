This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.proof.mgt;

import java.util.EventObject;

import de.uka.ilkd.key.proof.ProofAggregate;
import de.uka.ilkd.key.proof.init.ProofOblInput;

public class ProofEnvironmentEvent extends EventObject {

    private static final long serialVersionUID = 2846838426822302188L;

    private final ProofOblInput po;
    private final ProofAggregate proofList;

    public ProofEnvironmentEvent(ProofEnvironment source, ProofOblInput po,
            ProofAggregate proofList) {
        super(source);
        this.po = po;
        this.proofList = proofList;
    }


    @Override
    public ProofEnvironment getSource() {
        return (ProofEnvironment) super.getSource();
    }


    public ProofAggregate getProofList() {
        return proofList;
    }


    public ProofOblInput getPo() {
        return po;
    }



}
