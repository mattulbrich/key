This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.proof;

import de.uka.ilkd.key.java.abstraction.KeYJavaType;
import de.uka.ilkd.key.logic.op.IObserverFunction;

/**
 *
 * @author christoph
 */
public class ObserverWithType {

    public final KeYJavaType kjt;
    public final IObserverFunction obs;

    public ObserverWithType(KeYJavaType kjt,
            IObserverFunction obs) {
        this.kjt = kjt;
        this.obs = obs;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ObserverWithType && obj != null) {
            ObserverWithType o = (ObserverWithType) obj;
            return kjt.equals(o.kjt) && obs.equals(o.obs);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (this.kjt != null ? this.kjt.hashCode() : 0);
        hash = 53 * hash + (this.obs != null ? this.obs.hashCode() : 0);
        return hash;
    }
}
