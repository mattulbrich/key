This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.axiom_abstraction;

/**
 * <p>
 * A comparison function, which imposes a <i>partial ordering</i> on some
 * collection of objects.
 * </p>
 *
 * <p>
 * The ordering imposed by a comparator <tt>c</tt> on a set of elements
 * <tt>S</tt> is said to be <i>consistent with equals</i> if and only if
 * <tt>c.compare(e1, e2)==EQ</tt> has the same boolean value as
 * <tt>e1.equals(e2)</tt> for every <tt>e1</tt> and <tt>e2</tt> in
 * <tt>S</tt>.
 * <p>
 *
 * @param <T> the type of objects that may be compared by this comparator
 *
 * @author Dominic Scheurer
 * @see java.util.Comparator
 */
public interface PartialComparator<T> {

    /**
     * Possible results of the comparison.
     */
    public static enum PartialComparisonResult {
        LTE, GTE, EQ, UNDEF
    }

    /**
     * Compares its two arguments for order. If the arguments are incomparable,
     * UNDEF is returned. Otherwise, the method returns LTE, EQ, or GTE as the
     * first argument is less than, equal to, or greater than the second.
     * <p>
     *
     * @param o1 the first object to be compared.
     * @param o2 the second object to be compared.
     * @return LTE, EQ, or GTE as the first argument is less than, equal to, or
     *         greater than the second; returns UNDEF if the arguments are incomparable.
     */
    public PartialComparisonResult compare(T o1, T o2);

}
