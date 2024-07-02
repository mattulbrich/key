This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.gui.extension.api;

import java.util.Collections;
import java.util.List;
import javax.swing.*;

import de.uka.ilkd.key.gui.MainWindow;

public interface KeYToolbarExtensionAdapter extends KeYGuiExtension.Toolbar {
    /**
     * @param mainWindow
     * @return
     */
    default List<Action> getToolbarActions(MainWindow mainWindow) {
        return Collections.emptyList();
    }

    @Override
    default JToolBar getToolbar(MainWindow mainWindow) {
        JToolBar tb = new JToolBar(getClass().getName());
        getToolbarActions(mainWindow).forEach(tb::add);
        return tb;
    }
}
