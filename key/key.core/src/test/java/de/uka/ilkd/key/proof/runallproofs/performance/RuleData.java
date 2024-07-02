This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.proof.runallproofs.performance;

public class RuleData {

    int numberInvocations = 1;
    long duration;

    public RuleData(long computeCostDuration) {
        this.duration = computeCostDuration;
    }

    public void addDuration(long duration) {
        numberInvocations++;
        this.duration += duration;
    }

}
