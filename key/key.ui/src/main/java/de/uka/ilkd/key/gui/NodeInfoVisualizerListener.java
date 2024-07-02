This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.gui;

/**
 * A listener to the {@link NodeInfoVisualizer} class.
 * Listeners are notified whenever a visualizer is registered or unregistered from
 * {@link NodeInfoVisualizer#getInstances(de.uka.ilkd.key.proof.Node)}.
 *
 * @author lanzinger
 */
public interface NodeInfoVisualizerListener {

    /**
     * Called when a new visualizer has been registered.
     *
     * @param vis the registered visualizer.
     */
    void visualizerRegistered(NodeInfoVisualizer vis);

    /**
     * Called when a visualizer has been unregistered.
     *
     * @param vis the unregistered visualizer.
     */
    void visualizerUnregistered(NodeInfoVisualizer vis);
}
