This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.strategy.feature;

import de.uka.ilkd.key.logic.PosInOccurrence;
import de.uka.ilkd.key.proof.Goal;
import de.uka.ilkd.key.rule.RuleApp;
import de.uka.ilkd.key.strategy.RuleAppCost;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * For debugging purposes. Wraps a feature and prints the computed value
 */
public class PrintFeature implements Feature {
    private static final Logger LOGGER = LoggerFactory.getLogger(PrintFeature.class);

    private final Feature f;
    private final String prefix;

    public PrintFeature(String prefix, Feature f) {
        this.f = f;
        this.prefix = prefix;
    }

    public PrintFeature(Feature f) {
        this("", f);
    }


    @Override
    public RuleAppCost computeCost(RuleApp app, PosInOccurrence pos, Goal goal) {
        RuleAppCost cost = f.computeCost(app, pos, goal);
        LOGGER.debug("{}:{}:{}{}",
            prefix, cost.toString(), pos != null ? pos.subTerm() + ":" : "", app.rule().name());
        return cost;
    }



}
