This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.axiom_abstraction.boollattice;

import de.uka.ilkd.key.axiom_abstraction.AbstractDomainElement;

/**
 * A domain element of the simple boolean lattice.
 *
 * @author Dominic Scheurer
 */
public abstract class BooleanDomainElem extends AbstractDomainElement {

    /**
     * @return true iff this element is the bottom element.
     */
    public boolean isBottom() {
        return this instanceof Bottom;
    }

    /**
     * @return true iff this element is the false element.
     */
    public boolean isFalse() {
        return this instanceof False;
    }

    /**
     * @return true iff this element is the true element.
     */
    public boolean isTrue() {
        return this instanceof True;
    }

    /**
     * @return true iff this element is the top element.
     */
    public boolean isTop() {
        return this instanceof Top;
    }

}
