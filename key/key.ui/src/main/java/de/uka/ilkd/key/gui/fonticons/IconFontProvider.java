This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.gui.fonticons;

import java.awt.*;
import javax.swing.*;

public class IconFontProvider extends IconProvider {
    private final IconFont iconCode;
    private final Color color;

    public IconFontProvider(IconFont iconCode) {
        this(iconCode, Color.black);
    }

    public IconFontProvider(IconFont iconCode, Color color) {
        this.iconCode = iconCode;
        this.color = color;
    }

    @Override
    Icon load(float size) {
        return IconFontSwing.buildIcon(iconCode, size, color);
    }

    @Override
    String getKey(float size) {
        return iconCode.toString() + color + size;
    }
}
