This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.axiom_abstraction.boollattice;

import de.uka.ilkd.key.java.Services;
import de.uka.ilkd.key.logic.Name;
import de.uka.ilkd.key.logic.Term;
import de.uka.ilkd.key.logic.TermBuilder;
import de.uka.ilkd.key.logic.op.LogicVariable;

/**
 * The Bottom element of the boolean lattice, representing
 * no boolean at all.
 *
 * @author Dominic Scheurer
 */
public class Bottom extends BooleanDomainElem {

    private static final Bottom INSTANCE = new Bottom();

    private Bottom() {}

    public static Bottom getInstance() {
        return INSTANCE;
    }

    @Override
    public Name name() {
        return new Name("bottom");
    }

    @Override
    public Term getDefiningAxiom(Term varOrConst, Services services) {
        TermBuilder tb = services.getTermBuilder();

        final Name freshVarName = new Name(tb.newName(varOrConst.sort()));
        LogicVariable freshVar = new LogicVariable(freshVarName, varOrConst.sort());
        services.getNamespaces().variables().add(freshVar);

        Term axiom = tb.equals(varOrConst, tb.var(freshVar));
        axiom = tb.not(axiom);
        axiom = tb.all(freshVar, axiom);

        return axiom;
    }

    @Override
    public String toParseableString(Services services) {
        return toString();
    }

}
