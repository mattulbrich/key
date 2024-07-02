This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.axiom_abstraction;

import de.uka.ilkd.key.java.Services;
import de.uka.ilkd.key.logic.Named;
import de.uka.ilkd.key.logic.Term;

/**
 * An element of an abstract domain. Elements are described by defining axioms;
 * the main function of this class is to create such defining axioms for given
 * terms, usually Skolem constants or program variables.
 *
 * @author Dominic Scheurer
 */
public abstract class AbstractDomainElement implements Named {

    /**
     * <p>
     * Return the defining axiom, instantiated for a given Term (skolem constant
     * or logical / program variable). The term can be seen as a representative
     * of this abstract domain element; the returned formula must formally
     * specify this.
     * </p>
     *
     * <p>
     * If this element describes, for instance, all numbers divisible by 2, the
     * method could return the formula "varOrConst % 2 == 0".
     * </p>
     *
     * @param varOrConst
     *        The logical / program variable or skolem constant representing
     *        an instance of this abstract domain element.
     * @param services
     *        A services object.
     * @return A JavaDL formula expressing that the given variable or constant
     *         represents an instance of this abstract domain element.
     */
    public abstract Term getDefiningAxiom(Term varOrConst, Services services);

    /**
     * Returns a parseable String representation of this
     * {@link AbstractDomainElement}. It should always hold that, for an
     * {@link AbstractDomainElement} e and the corresponding
     * {@link AbstractDomainLattice} l, that
     * {@code l.fromString(e.toParseableString(),
     * services).equals(e)}.
     *
     * @param services
     *        The services object.
     * @return A parseable String representation of this domain element.
     */
    public abstract String toParseableString(Services services);

    @Override
    public String toString() {
        return name().toString();
    }

}
