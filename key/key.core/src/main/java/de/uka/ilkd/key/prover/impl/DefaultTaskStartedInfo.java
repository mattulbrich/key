This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.prover.impl;

import de.uka.ilkd.key.prover.TaskStartedInfo;

/**
 * Default implementation of a {@link TaskStartedInfo}.
 */
public class DefaultTaskStartedInfo implements TaskStartedInfo {

    private final TaskStartedInfo.TaskKind kind;
    private final String message;
    private final int size;

    public DefaultTaskStartedInfo(TaskKind kind, String message, int size) {
        super();
        this.kind = kind;
        this.message = message;
        this.size = size;
    }

    @Override
    public String toString() {
        return "DefaultTaskStartedInfo [kind=" + kind + ", message=" + message
            + ", size=" + size + "]";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TaskKind getKind() {
        return kind;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getMessage() {
        return message;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getSize() {
        return size;
    }
}
