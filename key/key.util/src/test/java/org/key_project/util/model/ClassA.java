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
public class ClassA {
    private int privateField = 1;

    protected int protectedField = 2;

    public int publicField = 3;

    int defaultField = 4;

    private String onlyInA = "A";

    private boolean booleanField = true;

    public static int staticField = -42;

    public static boolean staticBooleanField = false;

    public static String staticStringField = null;

    private int getPrivate() {
        return 42;
    }

    public int getPublic() {
        return 43;
    }

    protected int getProtected() {
        return 44;
    }

    int getDefault() {
        return 45;
    }

    private int getValue(Integer value) {
        return value;
    }

    private int getValue(Integer first, Integer second) {
        return first + second;
    }

    private String onlyInA() {
        return "A";
    }
}
