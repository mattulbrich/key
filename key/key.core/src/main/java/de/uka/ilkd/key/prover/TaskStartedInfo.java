This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.prover;

/**
 * Used as an event object to inform about a prover task
 * that is just about to start.
 */
public interface TaskStartedInfo {

    public enum TaskKind {
        Strategy, Macro, UserInterface, Loading, Other;
    }

    /**
     * allows to query about the nature of task
     *
     * @return the kind of the task
     */
    public TaskKind getKind();

    /**
     * returns a message with a description of the task, example: "Processing Strategy"
     */
    public String getMessage();

    /**
     * returns measure for the total size of the task. The number indicates the amount of work
     * needed to complete the task,
     * mostly used by the GUI to display a progress bar. A returned value of 0 means unknown size.
     */
    public int getSize();

}
