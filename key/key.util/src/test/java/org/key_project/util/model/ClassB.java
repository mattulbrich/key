This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package org.key_project.util.model;

@SuppressWarnings("unused")
public class ClassB extends ClassA {
    private int privateField = 42;

    protected int protectedField = 43;

    public int publicField = 44;

    int defaultField = 45;

    private String onlyInB = "B";

    private int getPrivate() {
        return 662;
    }

    public int getPublic() {
        return 663;
    }

    protected int getProtected() {
        return 664;
    }

    int getDefault() {
        return 665;
    }

    private String onlyInB() {
        return "B";
    }
}
