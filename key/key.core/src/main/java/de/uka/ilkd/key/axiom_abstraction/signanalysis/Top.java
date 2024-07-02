This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.axiom_abstraction.signanalysis;

import de.uka.ilkd.key.java.Services;
import de.uka.ilkd.key.logic.Name;
import de.uka.ilkd.key.logic.Term;
import de.uka.ilkd.key.logic.TermBuilder;

/**
 * The Top element of the sign lattice, representing
 * all integers.
 *
 * @author Dominic Scheurer
 */
public class Top extends SignAnalysisDomainElem {

    private static final Top INSTANCE = new Top();

    private Top() {}

    public static Top getInstance() {
        return INSTANCE;
    }

    @Override
    public Name name() {
        return new Name("top");
    }

    @Override
    public Term getDefiningAxiom(Term varOrConst, Services services) {
        TermBuilder tb = services.getTermBuilder();
        return tb.inInt(varOrConst);
    }

    @Override
    public String toParseableString(Services services) {
        return toString();
    }

}
