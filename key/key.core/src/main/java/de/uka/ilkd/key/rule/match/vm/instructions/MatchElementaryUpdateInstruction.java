This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.rule.match.vm.instructions;

import de.uka.ilkd.key.java.Services;
import de.uka.ilkd.key.logic.Term;
import de.uka.ilkd.key.logic.op.ElementaryUpdate;
import de.uka.ilkd.key.logic.op.LocationVariable;
import de.uka.ilkd.key.logic.op.Operator;
import de.uka.ilkd.key.logic.op.ProgramSV;
import de.uka.ilkd.key.rule.MatchConditions;
import de.uka.ilkd.key.rule.match.vm.TacletMatchProgram;
import de.uka.ilkd.key.rule.match.vm.TermNavigator;

public class MatchElementaryUpdateInstruction extends Instruction<ElementaryUpdate> {

    private final MatchOperatorInstruction leftHandSide;

    protected MatchElementaryUpdateInstruction(ElementaryUpdate op) {
        super(op);
        if (op.lhs() instanceof LocationVariable) {
            leftHandSide =
                new MatchOpIdentityInstruction<LocationVariable>((LocationVariable) op.lhs());
        } else {
            assert op.lhs() instanceof ProgramSV;
            leftHandSide = (MatchOperatorInstruction) TacletMatchProgram
                    .getMatchInstructionForSV((ProgramSV) op.lhs());
        }
    }

    @Override
    public MatchConditions match(Term instantiationCandidate,
            MatchConditions matchCond, Services services) {
        final Operator instantiationCandidateOp = instantiationCandidate.op();
        if (instantiationCandidateOp != op) {
            if (instantiationCandidateOp instanceof ElementaryUpdate) {
                final ElementaryUpdate instElUpdate = (ElementaryUpdate) instantiationCandidateOp;
                matchCond = leftHandSide.match(instElUpdate.lhs(), matchCond, services);
            } else {
                matchCond = null;
            }
        }
        return matchCond;
    }

    @Override
    public MatchConditions match(TermNavigator termPosition,
            MatchConditions matchConditions, Services services) {
        final MatchConditions result =
            match(termPosition.getCurrentSubterm(), matchConditions, services);
        if (result != null) {
            termPosition.gotoNext();
        }
        return result;
    }
}
