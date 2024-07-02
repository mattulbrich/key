This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.strategy.feature;

import de.uka.ilkd.key.logic.Name;
import de.uka.ilkd.key.logic.PosInOccurrence;
import de.uka.ilkd.key.logic.op.SchemaVariable;
import de.uka.ilkd.key.proof.Goal;
import de.uka.ilkd.key.rule.TacletApp;

public class SVNeedsInstantiation extends InstantiatedSVFeature {

    public static Feature create(String svName) {
        return new SVNeedsInstantiation(new Name(svName));
    }

    private Name svName;

    protected SVNeedsInstantiation(Name svName) {
        super(svName);
        this.svName = svName;
    }

    @Override
    protected boolean filter(TacletApp app, PosInOccurrence pos, Goal goal) {
        boolean res = super.filter(app, pos, goal);
        if (res == false) {
            for (SchemaVariable sv : app.uninstantiatedVars()) {
                if (sv.name().equals(svName)) {
                    return true;
                }
            }
        }
        return false;
    }


}
