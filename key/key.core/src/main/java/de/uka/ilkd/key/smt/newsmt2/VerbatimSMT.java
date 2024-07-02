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
 * Objects of this class are writable (like {@link SExpr}s), but are not
 * really structured as such. They are just arbitrary strings.
 *
 * Writing them is obvious.
 */
class VerbatimSMT implements Writable {

    private String string;

    public VerbatimSMT(String string) {
        this.string = string;
    }

    @Override
    public void appendTo(StringBuilder sb) {
        sb.append(string);
    }
}
