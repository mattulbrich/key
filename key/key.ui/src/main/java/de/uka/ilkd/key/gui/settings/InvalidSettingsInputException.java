This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.gui.settings;

import javax.swing.*;

/**
 * @author Alexander Weigl
 * @date 2019-04-11
 */
public class InvalidSettingsInputException extends Exception {
    private static final long serialVersionUID = -7504257775646675899L;
    private SettingsProvider panel;
    private JComponent focusable;

    public InvalidSettingsInputException(SettingsProvider panel, JComponent focusable) {
        this.panel = panel;
        this.focusable = focusable;
    }

    public InvalidSettingsInputException(String message, SettingsProvider panel,
            JComponent focusable) {
        super(message);
        this.panel = panel;
        this.focusable = focusable;
    }

    public InvalidSettingsInputException(String message, Throwable cause, SettingsProvider panel,
            JComponent focusable) {
        super(message, cause);
        this.panel = panel;
        this.focusable = focusable;
    }

    public InvalidSettingsInputException(Throwable cause, SettingsProvider panel,
            JComponent focusable) {
        super(cause);
        this.panel = panel;
        this.focusable = focusable;
    }

    public InvalidSettingsInputException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace, SettingsProvider panel, JComponent focusable) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.panel = panel;
        this.focusable = focusable;
    }

    public SettingsProvider getPanel() {
        return panel;
    }

    public JComponent getFocusable() {
        return focusable;
    }
}
