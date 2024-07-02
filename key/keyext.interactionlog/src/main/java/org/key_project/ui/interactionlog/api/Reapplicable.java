This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package org.key_project.ui.interactionlog.api;

import de.uka.ilkd.key.gui.WindowUserInterfaceControl;
import de.uka.ilkd.key.proof.Goal;

/**
 * @author Alexander Weigl
 * @version 1 (08.05.19)
 */
public interface Reapplicable {
    default void reapply(WindowUserInterfaceControl uic, Goal goal) throws Exception {
        throw new UnsupportedOperationException();
    }
}
