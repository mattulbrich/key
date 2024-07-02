This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.proof;

import java.net.URI;

import de.uka.ilkd.key.java.PositionInfo;
import de.uka.ilkd.key.logic.label.OriginTermLabel;

import org.key_project.util.collection.DefaultImmutableSet;
import org.key_project.util.collection.ImmutableSet;

/**
 * <p>
 * This collection represents the set containing URIs of all Java source files relevant to a given
 * {@link Proof}.
 * </p>
 *
 * <p>
 * This includes the files contained in the {@link PositionInfo} of all modalities
 * as well as the files in the {@link OriginTermLabel}s of all terms in this node's sequent.
 * </p>
 *
 * <p>
 * It can be accessed via {@code proof.lookup(ProofJavaSourceCollection)}.
 * </p>
 *
 * @author lanzinger
 */
public class ProofJavaSourceCollection {

    /** @see #getRelevantFiles() */
    private ImmutableSet<URI> relevantFiles = DefaultImmutableSet.nil();

    /**
     * <p>
     * Returns a set containing URIs of all files relevant to this proof.
     * </p>
     *
     * <p>
     * This includes the files contained in the {@link PositionInfo} of all modalities
     * as well as the files in the {@link OriginTermLabel}s of all terms in this node's sequent.
     * </p>
     *
     * @return the set of URIs of files relevant to this node.
     */
    public ImmutableSet<URI> getRelevantFiles() {
        return relevantFiles;
    }

    /**
     * Add a file to the set returned by {@link #getRelevantFiles()}.
     *
     * @param relevantFile the URI of the file to add.
     */
    public void addRelevantFile(URI relevantFile) {
        this.relevantFiles = this.relevantFiles.add(relevantFile);
    }

    /**
     * Add some files to the set returned by {@link #getRelevantFiles()}.
     *
     * @param relevantFiles the URIs of the files to add.
     */
    public void addRelevantFiles(ImmutableSet<URI> relevantFiles) {
        if (this.relevantFiles.isEmpty() || this.relevantFiles.subset(relevantFiles)) {
            this.relevantFiles = relevantFiles;
        } else {
            this.relevantFiles = this.relevantFiles.union(relevantFiles);
        }
    }

}
