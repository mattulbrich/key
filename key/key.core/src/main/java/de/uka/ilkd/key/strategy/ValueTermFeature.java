This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.strategy;

import de.uka.ilkd.key.logic.op.Equality;
import de.uka.ilkd.key.logic.op.Junctor;
import de.uka.ilkd.key.strategy.termfeature.TermFeature;

import static de.uka.ilkd.key.strategy.StaticFeatureCollection.op;

class ValueTermFeature {

    public ValueTermFeature(TermFeature nullTerm) {
        equals = op(Equality.EQUALS);
        tt = op(Junctor.TRUE);
        ff = op(Junctor.FALSE);
        this.nullTerm = nullTerm;
    }

    final TermFeature equals;
    final TermFeature tt;
    final TermFeature ff;
    final TermFeature nullTerm;
}
