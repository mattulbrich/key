This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.speclang.njml;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Nullable;

import de.uka.ilkd.key.java.Label;
import de.uka.ilkd.key.logic.Term;
import de.uka.ilkd.key.logic.op.LocationVariable;
import de.uka.ilkd.key.util.LinkedHashMap;
import de.uka.ilkd.key.util.Pair;

class ContractClauses {
    public @Nullable Term measuredBy;
    public @Nullable Term decreases;
    public @Nullable Term signals;
    public @Nullable Term signalsOnly;
    public @Nullable Term diverges;
    public @Nullable Term returns;

    static final Clauses<Label, Term> BREAKS = new Clauses<>();
    static final Clauses<Label, Term> CONTINUES = new Clauses<>();

    static final Clauses<LocationVariable, Term> ASSIGNABLE = new Clauses<>();
    static final Clauses<LocationVariable, Term> ACCESSIBLE = new Clauses<>();
    static final Clauses<LocationVariable, Term> ENSURES = new Clauses<>();
    static final Clauses<LocationVariable, Term> ENSURES_FREE = new Clauses<>();
    static final Clauses<LocationVariable, Term> REQUIRES = new Clauses<>();
    static final Clauses<LocationVariable, Term> REQUIRES_FREE = new Clauses<>();
    static final Clauses<LocationVariable, Term> AXIOMS = new Clauses<>();
    static final Clauses<LocationVariable, Boolean> HAS_MODS = new Clauses<>();


    @SuppressWarnings("unused")
    static class Clauses<K, V> {
    }

    private final Map<Clauses<?, ?>, List<Pair<Object, Object>>> clauseData = new LinkedHashMap<>();

    public <K, V> ContractClauses add(Clauses<K, V> type, K heapOrLabel, V t) {
        List<Pair<Object, Object>> list =
            clauseData.computeIfAbsent(type, key -> new LinkedList<>());
        list.add(new Pair<>(heapOrLabel, t));
        return this;
    }

    @SuppressWarnings("unchecked")
    public <K, V> List<Pair<K, V>> get(Clauses<K, V> type) {
        List<Pair<Object, Object>> list =
            clauseData.computeIfAbsent(type, key -> new LinkedList<>());
        return list.stream().map(p -> new Pair<>((K) p.first, (V) p.second))
                .collect(Collectors.toList());
    }
}
