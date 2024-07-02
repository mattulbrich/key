This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.rule;

import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

import de.uka.ilkd.key.logic.Semisequent;
import de.uka.ilkd.key.util.Pair;

import org.key_project.util.LRUCache;
import org.key_project.util.collection.ImmutableList;

// a simple cache for the results of the method <code>createList</code>
public final class IfFormulaInstantiationCache {

    private final LRUCache<Integer, Pair<Semisequent, ImmutableList<IfFormulaInstantiation>>> antecCache =
        new LRUCache<>(50);
    private final LRUCache<Integer, Pair<Semisequent, ImmutableList<IfFormulaInstantiation>>> succCache =
        new LRUCache<>(50);

    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private final ReadLock readLock = lock.readLock();
    private final WriteLock writeLock = lock.writeLock();

    public final ImmutableList<IfFormulaInstantiation> get(boolean antec, Semisequent s) {
        try {
            readLock.lock();
            final Pair<Semisequent, ImmutableList<IfFormulaInstantiation>> p =
                (antec ? antecCache : succCache).get(System.identityHashCode(s));
            return p != null && p.first == s ? p.second : null;
        } finally {
            readLock.unlock();
        }
    }

    public final void put(boolean antec, Semisequent s,
            ImmutableList<IfFormulaInstantiation> value) {
        try {
            writeLock.lock();
            (antec ? antecCache : succCache).put(System.identityHashCode(s), new Pair<>(s, value));
        } finally {
            writeLock.unlock();
        }
    }
}
