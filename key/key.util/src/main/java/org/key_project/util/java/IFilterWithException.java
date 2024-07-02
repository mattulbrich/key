This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package org.key_project.util.java;

/**
 * Utility class to select elements which also allows that exceptions
 * are thrown during selection phase.
 *
 * @author Martin Hentschel
 */
public interface IFilterWithException<T, E extends Throwable> {
    /**
     * Checks if the given element should be selected.
     *
     * @param element The element to test.
     * @return {@code true} handle element, {@code false} ignore element.
     * @throws E An occurred exception.
     */
    public boolean select(T element) throws E;
}
