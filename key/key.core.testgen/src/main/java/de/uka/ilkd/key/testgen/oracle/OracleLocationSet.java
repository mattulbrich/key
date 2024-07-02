This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.testgen.oracle;

import java.util.HashSet;
import java.util.Set;

public class OracleLocationSet {

    private Set<OracleLocation> locs;

    public static final EmptyOracleLocationSet EMPTY = new EmptyOracleLocationSet();

    public static final AllLocsLocationSet ALL_LOCS = new AllLocsLocationSet();


    public OracleLocationSet() {
        locs = new HashSet<OracleLocation>();
    }

    private void add(OracleLocation loc) {
        locs.add(loc);
    }

    private void add(OracleLocationSet loc) {
        locs.addAll(loc.locs);
    }

    public static OracleLocationSet singleton(OracleLocation loc) {
        OracleLocationSet result = new OracleLocationSet();
        result.add(loc);
        return result;
    }

    public static OracleLocationSet union(OracleLocationSet l1, OracleLocationSet l2) {

        if (l1 == ALL_LOCS || l2 == ALL_LOCS) {
            return ALL_LOCS;
        }

        if (l1 == EMPTY) {
            return l2;
        }

        if (l2 == EMPTY) {
            return l1;
        }

        OracleLocationSet result = new OracleLocationSet();
        result.add(l1);
        result.add(l2);
        return result;
    }

    public static OracleLocationSet intersect(OracleLocationSet l1, OracleLocationSet l2) {

        if (l1 == EMPTY || l2 == EMPTY) {
            return EMPTY;
        }

        if (l1 == ALL_LOCS) {
            return l2;
        }

        if (l2 == ALL_LOCS) {
            return l1;
        }

        OracleLocationSet result = new OracleLocationSet();
        for (OracleLocation l : l1.locs) {
            if (l2.contains(l)) {
                result.add(l);
            }
        }


        for (OracleLocation l : l2.locs) {
            if (l1.contains(l)) {
                result.add(l);
            }
        }

        return result;
    }

    public boolean contains(OracleLocation l) {
        for (OracleLocation loc : locs) {

            if (loc.equals(l)) {
                return true;
            }

            if (loc.isAllFields() && loc.getObject().equals(l.getObject())) {
                return true;
            }

        }

        return false;
    }

    public String toString() {

        if (this == EMPTY) {
            return "Empty";
        }

        if (this == ALL_LOCS) {
            return "All";
        }


        String result = "";

        result += "{";

        for (OracleLocation loc : locs) {
            result += loc + " ";
        }

        result += "}";


        return result;


    }

}


class EmptyOracleLocationSet extends OracleLocationSet {
    public boolean contains(OracleLocation l) {
        return false;
    }
}


class AllLocsLocationSet extends OracleLocationSet {
    public boolean contains(OracleLocation l) {
        return true;
    }
}
