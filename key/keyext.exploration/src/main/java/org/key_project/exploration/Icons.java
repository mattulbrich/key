This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package org.key_project.exploration;

import java.awt.*;
import javax.swing.*;

import de.uka.ilkd.key.gui.fonticons.*;

/**
 * Icons of the Exploration Extension
 *
 * @author Alexander Weigl
 * @version 1 (22.07.19)
 */
public class Icons {
    public static final IconFontProvider WARNING =
        new IconFontProvider(MaterialDesignRegular.WARNING, Color.yellow);

    public static final Image SECOND_BRANCH_IMAGE =
        IconFontSwing.buildImage(FontAwesomeSolid.SHARE_ALT, 16, Color.BLACK, 90.0);

    public static final IconFontProvider EXPLORE =
        new IconFontProvider(MaterialDesignRegular.EXPLORE);

    public static final Icon SECOND_BRANCH = new ImageIcon(SECOND_BRANCH_IMAGE);

    public static final IconProvider SECOND_BRANCH_HIDE = new IconFontProvider(
        FontAwesomeSolid.ELLIPSIS_V);
    public static final IconFontProvider EXPLORE_DISABLE =
        new IconFontProvider(MaterialDesignRegular.EXPLORE, Color.GRAY);

    private Icons() {
    }
}
