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
 * A {@link Runnable} that has a result that is accessible via {@link #getResult()}.
 * </p>
 * <p>
 * Concrete implementations should be subclasses of {@link AbstractRunnableWithResult}.
 * </p>
 *
 * @author Martin Hentschel
 * @see AbstractRunnableWithResult
 */
public interface IRunnableWithResult<T> extends IRunnableWithException {
    /**
     * Returns the result.
     *
     * @return The result.
     */
    public T getResult();

    /**
     * Returns an occurred exception.
     *
     * @return An occurred exception.
     */
    public Exception getException();
}
