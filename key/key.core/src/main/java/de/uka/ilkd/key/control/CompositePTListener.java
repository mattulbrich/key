This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.control;

import de.uka.ilkd.key.prover.ProverTaskListener;
import de.uka.ilkd.key.prover.TaskFinishedInfo;
import de.uka.ilkd.key.prover.TaskStartedInfo;

/**
 * A composite structure for prover task listeners.
 * For the moment, this is only used for the application
 * of proof macros at the outermost level.
 *
 * @author Michael Kirsten
 */
public class CompositePTListener implements ProverTaskListener {
    private ProverTaskListener[] listeners;

    public CompositePTListener(ProverTaskListener[] l) {
        this.listeners = l;
    }

    public CompositePTListener(ProverTaskListener ptl1,
            ProverTaskListener ptl2) {
        this(new ProverTaskListener[] { ptl1, ptl2 });
    }

    @Override
    public void taskStarted(TaskStartedInfo info) {
        for (ProverTaskListener l : listeners) {
            if (l != null) {
                l.taskStarted(info);
            }
        }
    }

    @Override
    public void taskProgress(int position) {
        for (ProverTaskListener l : listeners) {
            if (l != null) {
                l.taskProgress(position);
            }
        }
    }

    @Override
    public void taskFinished(TaskFinishedInfo info) {
        for (int i = listeners.length - 1; 0 <= i; i--) {
            ProverTaskListener l = listeners[i];
            if (l != null) {
                l.taskFinished(info);
            }
        }
    }
}
