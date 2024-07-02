This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.gui.fonticons;

import javax.swing.*;

public abstract class IconProvider {
    Icon load() {
        return load(16);
    }

    abstract Icon load(float height);

    abstract String getKey(float size);

    public Icon get() {
        return get(IconFactory.DEFAULT_SIZE);
    }

    public Icon get(float height) {
        return IconFactory.get(this, height);
    }
}
