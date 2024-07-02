This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.informationflow.macros;

import de.uka.ilkd.key.macros.AlternativeMacro;
import de.uka.ilkd.key.macros.ProofMacro;

public class FinishAuxiliaryComputationMacro extends AlternativeMacro {

    @Override
    public String getName() {
        return "Finish auxiliary computation";
    }

    @Override
    public String getCategory() {
        return "Auxiliary Computation";
    }

    @Override
    public String getDescription() {
        return "Finish auxiliary computation";
    }

    @Override
    public String getScriptCommandName() {
        return "aux-finish";
    }

    @Override
    protected ProofMacro[] createProofMacroArray() {
        return new ProofMacro[] { new FinishAuxiliaryMethodComputationMacro(),
            new FinishAuxiliaryLoopComputationMacro(),
            new FinishAuxiliaryBlockComputationMacro() };
    }
}
