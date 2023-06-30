package de.uka.ilkd.key.rule;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.annotation.Nonnull;

import de.uka.ilkd.key.java.Services;
import de.uka.ilkd.key.logic.*;
import de.uka.ilkd.key.logic.label.TermLabel;
import de.uka.ilkd.key.logic.op.Modality;
import de.uka.ilkd.key.logic.op.Operator;
import de.uka.ilkd.key.logic.op.UpdateApplication;
import de.uka.ilkd.key.proof.Goal;
import de.uka.ilkd.key.proof.Node;

import org.key_project.util.collection.ImmutableArray;
import org.key_project.util.collection.ImmutableList;

/**
 * A builtin rule that allows you to recall that a formula has already been present on the sequent
 * in the past.
 *
 * It is sound to assume that this formula still be present on the sequent. Hence it can be used to
 * replace toplevel formulas with true or false (like replaceKnownRight / Left).
 *
 * @author Mattias Ulbrich
 */
public class RecallFormulaRule implements BuiltInRule {

    public static final RecallFormulaRule INSTANCE = new RecallFormulaRule();
    private final static Name NAME = new Name("Recall");
    public static final ImmutableArray<TermLabel> NO_LABELS = new ImmutableArray<>();
    private int cachedNode = -1;
    private final Set<Term> seenAnteTerms = new HashSet<>();
    private final Set<Term> seenSuccTerms = new HashSet<>();

    @Override
    public Name name() {
        return NAME;
    }

    @Override
    public String displayName() {
        return NAME.toString();
    }

    @Override
    public String toString() {
        return displayName();
    }

    @Override
    public boolean isApplicableOnSubTerms() {
        return true;
    }

    @Override
    public boolean isApplicable(Goal goal, PosInOccurrence pio) {
        if (pio == null || isBelowUpdateOrModality(pio)) {
            return false;
        }
        updateCache(goal);
        Term term = removeLabels(goal.proof().getServices().getTermFactory(), pio.subTerm());
        if (pio.isTopLevel()) {
            if (pio.isInAntec()) {
                return seenSuccTerms.contains(term);
            } else {
                return seenAnteTerms.contains(term);
            }
        }
        return seenAnteTerms.contains(term) || seenSuccTerms.contains(term);
    }

    private boolean isBelowUpdateOrModality(PosInOccurrence pio) {
        while (!pio.isTopLevel()) {
            pio = pio.up();
            Operator op = pio.subTerm().op();
            if (op instanceof Modality || op instanceof UpdateApplication) {
                return true;
            }
        }
        return false;
    }

    private void updateCache(Goal goal) {
        if (cachedNode == goal.node().serialNr()) {
            return;
        }
        seenAnteTerms.clear();
        seenSuccTerms.clear();
        Node n = goal.node();
        var tf = goal.proof().getServices().getTermFactory();
        while (n != null) {
            seenAnteTerms.addAll(n.sequent().antecedent().asList()
                    .map(it -> removeLabels(tf, it.formula())).toList());
            seenSuccTerms.addAll(n.sequent().succedent().asList()
                    .map(it -> removeLabels(tf, it.formula())).toList());
            n = n.parent();
        }
        cachedNode = goal.node().serialNr();
    }

    @Override
    public IBuiltInRuleApp createApp(PosInOccurrence pos, TermServices services) {
        return new DefaultBuiltInRuleApp(this, pos);
    }

    @Nonnull
    @Override
    public ImmutableList<Goal> apply(Goal goal, Services services, RuleApp ruleApp)
            throws RuleAbortException {
        updateCache(goal);
        var pio = ruleApp.posInOccurrence();
        Term term = removeLabels(services.getTermFactory(), pio.subTerm());
        Term replacewith;
        if ((!pio.isTopLevel() || pio.isInAntec()) && seenSuccTerms.contains(term)) {
            replacewith = services.getTermBuilder().ff();
        } else if ((!pio.isTopLevel() || !pio.isInAntec()) && seenAnteTerms.contains(term)) {
            replacewith = services.getTermBuilder().tt();
        } else {
            throw new RuleAbortException(term + " is not to be found in history ...");
        }

        Term replaced = replace(services.getTermFactory(), pio.topLevel().subTerm(),
            pio.posInTerm().iterator(), replacewith);

        ImmutableList<Goal> goals = goal.split(1);
        goals.head().changeFormula(new SequentFormula(replaced), pio.topLevel());
        return goals;
    }

    /*
     * Replace a subterm in "term" by "replacewith". The position is given
     * by position in term represented by the integer iterator.
     *
     * @return a freshly created term wrapping the replacement
     */
    private Term replace(TermFactory tf, Term term, IntIterator it, Term replacewith) {
        if (!it.hasNext()) {
            return replacewith;
        } else {
            int idx = it.next();
            List<Term> subs = term.subs().toList();
            subs.set(idx, replace(tf, subs.get(idx), it, replacewith));
            ImmutableArray<Term> subArray = new ImmutableArray<>(subs);
            return tf.createTerm(term.op(), subArray, term.boundVars(), term.javaBlock(),
                term.getLabels());
        }
    }

    /**
     * See SymbolicExecutionUtil#removeLabelRecursive:
     *
     * Removes termlabels from the given {@link Term} and from all of its children.
     *
     * @param tf The {@link TermFactory} to use.
     * @param term The {@link Term} to remove label from.
     * @return A new {@link Term} without labels.
     */
    private static Term removeLabels(TermFactory tf, Term term) {
        // Update children
        List<Term> newSubs = new LinkedList<>();
        ImmutableArray<Term> oldSubs = term.subs();
        boolean changed = false;
        for (Term oldSub : oldSubs) {
            Term newSub = removeLabels(tf, oldSub);
            changed |= (newSub != oldSub);
            newSubs.add(newSub);
        }
        if (changed) {
            return tf.createTerm(term.op(), new ImmutableArray<>(newSubs), term.boundVars(),
                term.javaBlock(), NO_LABELS);
        } else if (term.hasLabels()) {
            return tf.createTerm(term.op(), oldSubs, term.boundVars(),
                term.javaBlock(), NO_LABELS);
        } else {
            return term;
        }

    }

}
