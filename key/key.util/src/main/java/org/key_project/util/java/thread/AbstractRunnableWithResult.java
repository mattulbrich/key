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
 * Provides a basic implementation of {@link IRunnableWithResult}.
 * </p>
 * <p>
 * The concrete implementations have to set the result
 * via {@link #setResult(Object)} in {@link #run()}.
 * </p>
 *
 * @author Martin Hentschel
 * @see IRunnableWithResult
 */
public abstract class AbstractRunnableWithResult<T> extends AbstractRunnableWithException
        implements IRunnableWithResult<T> {
    /**
     * The result.
     */
    private T result;

    /**
     * {@inheritDoc}
     */
    @Override
    public T getResult() {
        return result;
    }

    /**
     * Sets the result.
     *
     * @param result The result to set.
     */
    protected void setResult(T result) {
        this.result = result;
    }
}
