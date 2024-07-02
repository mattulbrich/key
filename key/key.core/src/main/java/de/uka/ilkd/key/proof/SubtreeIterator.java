This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.proof;

import java.util.Iterator;

/**
 * Iterator over subtree. Current implementation iteratively traverses the tree
 * depth-first.
 *
 * @author bruns
 */
class SubtreeIterator implements Iterator<Node> {

    private final Node root;
    private Node n;
    private boolean atRoot = true; // special handle

    SubtreeIterator(Node root) {
        assert root != null;
        this.n = root;
        this.root = root;
    }

    private Node nextSibling(Node m) {
        Node p = m.parent();
        while (p != null && m != root) {
            final int c = p.childrenCount();
            final int x = p.getChildNr(m);
            if (x + 1 < c) {
                final Node result = p.child(x + 1);
                return result != root ? result : null;
            }
            m = p;
            p = m.parent();
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        if (atRoot) {
            return true;
        }
        if (!n.leaf()) {
            return true;
        }
        return nextSibling(n) != null;
    }

    @Override
    public Node next() {
        if (atRoot) { // stay at root once
            atRoot = false;
            return n;
        }
        if (n.leaf()) {
            Node s = nextSibling(n);
            if (s != null) {
                n = s;
            }
        } else {
            n = n.child(0);
        }
        return n;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Changing the proof tree "
            + "structure this way is not allowed.");
    }
}
