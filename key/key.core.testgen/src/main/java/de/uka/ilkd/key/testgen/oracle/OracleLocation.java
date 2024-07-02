This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.testgen.oracle;

public class OracleLocation {

    public static String ALL_FIELDS = "<allFields>";

    private String object;

    private String field;

    public OracleLocation(String object, String field) {
        this.object = object;
        this.field = field;
    }

    public OracleLocation(String object) {
        this.object = object;
        this.field = ALL_FIELDS;
    }


    public String getObject() {
        return object;
    }


    public String getField() {
        return field;
    }

    public boolean isAllFields() {
        return field.equals(ALL_FIELDS);
    }

    public boolean equals(Object o) {

        if (o instanceof OracleLocation) {
            OracleLocation l = (OracleLocation) o;
            return object.equals(l.object) && field.equals(l.field);
        }

        return false;

    }

    public String toString() {

        if (field.startsWith("[")) {
            return object + field;
        } else {
            return object + "." + field;
        }


    }

}
