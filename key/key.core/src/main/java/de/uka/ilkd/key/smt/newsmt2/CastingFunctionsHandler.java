This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.smt.newsmt2;

import java.util.Properties;

import de.uka.ilkd.key.java.Services;
import de.uka.ilkd.key.logic.Term;
import de.uka.ilkd.key.logic.op.Operator;
import de.uka.ilkd.key.logic.op.SortDependingFunction;
import de.uka.ilkd.key.logic.sort.Sort;
import de.uka.ilkd.key.smt.SMTTranslationException;

/**
 * This SMT translation handler takes care of those sort-depending functions f whose return type is
 * coerced, i.e.
 *
 * <pre>
 *     T::f(params) = T::cast(any::f(params))
 * </pre>
 *
 * Currently these are: seqGet and (heap-) select.
 *
 * @author Mattias Ulbrich
 * @see CastHandler
 */
public class CastingFunctionsHandler implements SMTHandler {

    private SortDependingFunction seqGet;
    private SortDependingFunction select;

    @Override
    public void init(MasterHandler masterHandler, Services services, Properties handlerSnippets) {
        this.seqGet = services.getTypeConverter().getSeqLDT().getSeqGet(Sort.ANY, services);
        this.select = services.getTypeConverter().getHeapLDT().getSelect(Sort.ANY, services);
        masterHandler.addDeclarationsAndAxioms(handlerSnippets);
    }

    @Override
    public boolean canHandle(Operator op) {
        if (op instanceof SortDependingFunction) {
            SortDependingFunction sdf = (SortDependingFunction) op;
            return seqGet.isSimilar(sdf) || select.isSimilar(sdf);
        }
        return false;
    }

    @Override
    public SExpr handle(MasterHandler trans, Term term) throws SMTTranslationException {
        Operator op = term.op();
        SortDependingFunction sdf = (SortDependingFunction) op;
        String name = sdf.getKind().toString();
        String prefixedName = DefinedSymbolsHandler.PREFIX + name;
        trans.introduceSymbol(name);
        SExpr result = trans.handleAsFunctionCall(prefixedName, term);
        Sort dep = sdf.getSortDependingOn();
        if (dep == Sort.ANY) {
            return result;
        } else {
            trans.addSort(dep);
            trans.introduceSymbol("cast");
            return SExprs.castExpr(SExprs.sortExpr(dep), result);
        }
    }
}
