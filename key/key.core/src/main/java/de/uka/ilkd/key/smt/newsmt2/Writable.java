This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.smt.newsmt2;

/**
 * Writeable objects have the possibility to be written to a
 * {@link StringBuilder}.
 *
 * This avoids to explicitly invoke {@link #toString()} on larger objects which
 * might be inefficient.
 *
 * Most prominent subclass is {@link SExpr}.
 *
 * @author Mattias Ulbrich
 *
 * @see SExpr
 * @see VerbatimSMT
 */
public interface Writable {
    void appendTo(StringBuilder sb);
}
