This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

// This file is part of KeY - Integrated Deductive Software Design
//
// Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
// Universitaet Koblenz-Landau, Germany
// Chalmers University of Technology, Sweden
// Copyright (C) 2011-2014 Karlsruhe Institute of Technology, Germany
// Technical University Darmstadt, Germany
// Chalmers University of Technology, Sweden
//
// The KeY system is protected by the GNU General
// Public License. See LICENSE.TXT for details.
//

package de.uka.ilkd.key.proof;

import de.uka.ilkd.key.logic.PosInOccurrence;
import de.uka.ilkd.key.rule.RuleApp;

import org.key_project.util.collection.ImmutableList;

/**
 * Implementation of the NewRuleListener interface
 * that does nothing
 */
public class NullNewRuleListener implements NewRuleListener {

    @Override
    public void ruleAdded(RuleApp rule,
            PosInOccurrence pos) {
    }

    @Override
    public void rulesAdded(ImmutableList<? extends RuleApp> rule,
            PosInOccurrence pos) {
    }

    public static final NewRuleListener INSTANCE = new NullNewRuleListener();

}
