This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.gui.extension.api;

import java.util.Collection;
import java.util.Collections;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.swing.*;

import bibliothek.gui.dock.common.action.CAction;
import bibliothek.gui.dock.common.intern.DefaultCDockable;

/**
 * @author Alexander Weigl
 * @version 1 (23.04.19)
 */
public interface TabPanel {
    @Nonnull
    String getTitle();

    default @Nullable Icon getIcon() {
        return null;
    }

    @Nonnull
    JComponent getComponent();

    /**
     * @return non-null
     */
    default @Nonnull Collection<Action> getTitleActions() {
        return Collections.emptyList();
    }

    /**
     * @return
     */
    default @Nonnull Collection<CAction> getTitleCActions() {
        return Collections.emptyList();
    }

    default @Nullable DefaultCDockable.Permissions getPermissions() {
        return null;
    }
}
