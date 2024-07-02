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
 * The Geq element of the sign lattice, representing
 * all positive integers and zero.
 *
 * @author Dominic Scheurer
 */
public class Geq extends SignAnalysisDomainElem {

    private static final Geq INSTANCE = new Geq();

    private Geq() {}

    public static Geq getInstance() {
        return INSTANCE;
    }

    @Override
    public Name name() {
        return new Name("geq");
    }

    @Override
    public Term getDefiningAxiom(Term varOrConst, Services services) {
        TermBuilder tb = services.getTermBuilder();
        return services.getTermBuilder().geq(varOrConst, tb.zero());
    }

    @Override
    public String toParseableString(Services services) {
        return toString();
    }

}
