This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.proof.io.intermediate;

/**
 * Node in an intermediate proof representation modeling a branch
 * node. This node has a title (branch identifier) should have
 * exactly one child. Only exception: An empty proof; in this case,
 * there is the only branch "dummy ID" that has no parseable children.
 *
 * @author Dominic Scheurer
 */
public class BranchNodeIntermediate extends NodeIntermediate {

    private String branchTitle = null;

    public BranchNodeIntermediate(String branchTitle) {
        this.branchTitle = branchTitle;
    }

    public String getBranchTitle() {
        return branchTitle;
    }

}
