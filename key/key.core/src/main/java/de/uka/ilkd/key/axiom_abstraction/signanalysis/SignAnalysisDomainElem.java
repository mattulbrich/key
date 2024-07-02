This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.axiom_abstraction.signanalysis;

import de.uka.ilkd.key.axiom_abstraction.AbstractDomainElement;

/**
 * A domain element for sign analysis.
 *
 * @author Dominic Scheurer
 */
public abstract class SignAnalysisDomainElem extends AbstractDomainElement {

    /**
     * @return true iff this element is the bottom element.
     */
    public boolean isBottom() {
        return this instanceof Bottom;
    }

    /**
     * @return true iff this element is the neg element.
     */
    public boolean isNeg() {
        return this instanceof Neg;
    }

    /**
     * @return true iff this element is the zero element.
     */
    public boolean isZero() {
        return this instanceof Zero;
    }

    /**
     * @return true iff this element is the pos element.
     */
    public boolean isPos() {
        return this instanceof Pos;
    }

    /**
     * @return true iff this element is the leq element.
     */
    public boolean isLeq() {
        return this instanceof Leq;
    }

    /**
     * @return true iff this element is the geq element.
     */
    public boolean isGeq() {
        return this instanceof Geq;
    }

    /**
     * @return true iff this element is the top element.
     */
    public boolean isTop() {
        return this instanceof Top;
    }

}
