/**
 * this class represents a heuristic. Taclets can belong to different heuristics and are executed
 * automatic if these are selected. A heuristic is just a name.
 */
package de.uka.ilkd.key.rule;

import de.uka.ilkd.key.logic.Name;
import de.uka.ilkd.key.logic.Named;

public class RuleSet implements Named {
    /** name of the heuristic */
    private final Name name;


    /**
     * creates a heuristic
     *
     * @param name Name object that contains name of the heuristic
     */
    public RuleSet(Name name) {
        this.name = name;
    }

    /**
     * gets name of the heuristic
     *
     * @return Name object that is the name of the heuristic
     */
    public Name name() {
        return name;
    }

    public int hashCode() {
        return 3 * name().hashCode();
    }

    /**
     * returns true it the o is the same object as this
     */
    public boolean equals(Object o) {
        if (o instanceof RuleSet) {
            return this.name().equals(((RuleSet) o).name());
        }
        return false;
    }


    /** toString */
    public String toString() {
        return name.toString();
    }
}
