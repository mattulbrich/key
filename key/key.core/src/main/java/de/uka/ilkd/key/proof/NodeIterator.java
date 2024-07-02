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

class NodeIterator implements Iterator<Node> {

    private final Iterator<Node> it;

    NodeIterator(Iterator<Node> it) {
        this.it = it;
    }

    @Override
    public boolean hasNext() {
        return it.hasNext();
    }

    @Override
    public Node next() {
        return it.next();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Changing the proof tree "
            + "structure this way is not allowed.");
    }
}
