This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.rule.label;

import de.uka.ilkd.key.java.Services;
import de.uka.ilkd.key.logic.JavaBlock;
import de.uka.ilkd.key.logic.PosInOccurrence;
import de.uka.ilkd.key.logic.Term;
import de.uka.ilkd.key.logic.label.OriginTermLabel;
import de.uka.ilkd.key.logic.label.OriginTermLabel.FileOrigin;
import de.uka.ilkd.key.logic.label.OriginTermLabel.SpecType;
import de.uka.ilkd.key.logic.label.TermLabel;
import de.uka.ilkd.key.logic.label.TermLabelState;
import de.uka.ilkd.key.logic.op.Operator;
import de.uka.ilkd.key.logic.op.QuantifiableVariable;
import de.uka.ilkd.key.proof.Goal;
import de.uka.ilkd.key.rule.Rule;
import de.uka.ilkd.key.settings.ProofIndependentSettings;

import org.key_project.util.collection.ImmutableArray;

/**
 * Policy for {@link OriginTermLabel}s.
 *
 * This ensures that every term always has a valid term label, i.e., that no labels are lost.
 *
 * @author lanzinger
 */
public class OriginTermLabelPolicy implements TermLabelPolicy {

    @Override
    public TermLabel keepLabel(TermLabelState state, Services services,
            PosInOccurrence applicationPosInOccurrence, Term applicationTerm, Rule rule, Goal goal,
            Object hint, Term tacletTerm, Operator newTermOp, ImmutableArray<Term> newTermSubs,
            ImmutableArray<QuantifiableVariable> newTermBoundVars, JavaBlock newTermJavaBlock,
            ImmutableArray<TermLabel> newTermOriginalLabels, TermLabel label) {
        if (services.getProof() == null) {
            return label;
        }

        if (!ProofIndependentSettings.DEFAULT_INSTANCE
                .getTermLabelSettings().getUseOriginLabels()) {
            return null;
        }

        if (!OriginTermLabel.canAddLabel(newTermOp, services)) {
            return null;
        }

        OriginTermLabel newLabel = (OriginTermLabel) label;
        OriginTermLabel oldLabel = null;

        for (TermLabel l : newTermOriginalLabels) {
            if (l instanceof OriginTermLabel && l != newLabel) {
                oldLabel = (OriginTermLabel) l;
                break;
            }
        }

        OriginTermLabel result;

        if (oldLabel == null) {
            result = newLabel;
        } else {
            result = oldLabel;
        }

        if (result.getOrigin().specType == SpecType.NONE && result.getSubtermOrigins().isEmpty()) {
            result = null;
        }

        return result;
    }
}
