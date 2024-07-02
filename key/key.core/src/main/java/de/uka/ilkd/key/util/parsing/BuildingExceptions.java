This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.util.parsing;

import java.util.List;

/**
 * @author Alexander Weigl
 * @version 1 (12/4/19)
 */
public class BuildingExceptions extends RuntimeException {
    private final List<BuildingIssue> errors;

    public BuildingExceptions(List<BuildingIssue> errors) {
        super("Multiple errors occured");
        this.errors = errors;
    }

    public List<BuildingIssue> getErrors() {
        return errors;
    }
}
