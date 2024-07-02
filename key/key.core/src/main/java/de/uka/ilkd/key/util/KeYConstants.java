This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.util;

public interface KeYConstants {
    public static final String INTERNAL_VERSION = KeYResourceManager.getManager().getSHA1();

    public static final String VERSION =
        KeYResourceManager.getManager().getVersion() + " (internal: " + INTERNAL_VERSION + ")";

    public static final String COPYRIGHT = UnicodeHelper.COPYRIGHT
        + " Copyright 2001"
        + UnicodeHelper.ENDASH
        + "2021 "
        + "Karlsruhe Institute of Technology, "
        + "Chalmers University of Technology, and Technische Universit\u00e4t Darmstadt";
}
