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

package de.uka.ilkd.key.rule.inst;


import de.uka.ilkd.key.logic.Term;
import de.uka.ilkd.key.logic.op.SchemaVariable;
import de.uka.ilkd.key.rule.Taclet;

import org.key_project.util.collection.ImmutableMap;

/**
 * this class contains a Taclet together with its suggested
 * instantiations.
 */
public class TacletInstantiations {

    /** the rule */
    private Taclet rule;
    /** the instantations */
    private ImmutableMap<SchemaVariable, Term> instantiations;

    public TacletInstantiations(Taclet rule,
            ImmutableMap<SchemaVariable, Term> instantiations) {
        this.rule = rule;
        this.instantiations = instantiations;
    }

    public Taclet taclet() {
        return rule;
    }

    public ImmutableMap<SchemaVariable, Term> instantiations() {
        return instantiations;
    }

    public String toString() {
        return "rule: " + taclet() + "; instantiation: " + instantiations();
    }


}
