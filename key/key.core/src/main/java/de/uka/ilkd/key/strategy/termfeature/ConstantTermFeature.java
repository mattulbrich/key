This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.strategy.termfeature;

import de.uka.ilkd.key.java.Services;
import de.uka.ilkd.key.logic.Term;
import de.uka.ilkd.key.logic.op.Function;

public class ConstantTermFeature extends BinaryTermFeature {

    public static final TermFeature INSTANCE = new ConstantTermFeature();

    private ConstantTermFeature() {
    }

    @Override
    protected boolean filter(Term term, Services services) {
        return term.op() instanceof Function && term.arity() == 0;
    }

}
