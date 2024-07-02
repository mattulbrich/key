This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.rule;

import javax.annotation.Nullable;

/**
 * Classes with this interfaces provides a simple human-readable String where they came from.
 *
 * @author Alexander Weigl
 * @version 1 (12/30/21)
 */
public interface HasOrigin {
    /**
     * Information about the origin of the rule.
     * <p>
     * Should be a human-readable location where the user can find the declaration of the rule.
     * <p>
     * This field is set by the parser with [url]:[lineNumber]
     */
    @Nullable
    default String getOrigin() {
        return null;
    }
}
