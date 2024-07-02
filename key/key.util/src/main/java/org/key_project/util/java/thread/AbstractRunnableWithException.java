This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package org.key_project.util.java.thread;

/**
 * <p>
 * Provides a basic implementation of {@link IRunnableWithException}.
 * </p>
 * <p>
 * The concrete implementations have to set the exception
 * via {@link #setException(Exception)} in {@link #run()}.
 * </p>
 *
 * @author Martin Hentschel
 * @see IRunnableWithResult
 */
public abstract class AbstractRunnableWithException implements IRunnableWithException {
    /**
     * An occurred exception.
     */
    private Exception exception;

    /**
     * {@inheritDoc}
     */
    @Override
    public Exception getException() {
        return exception;
    }

    /**
     * Sets the occurred exception.
     *
     * @param exception The occurred exception.
     */
    protected void setException(Exception exception) {
        this.exception = exception;
    }
}
