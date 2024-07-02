This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.smt.st;

import de.uka.ilkd.key.smt.VersionChecker;

/**
 * @author Alexander Weigl
 * @version 1 (9/29/21)
 */
public class INVISMTSolverType extends Z3SolverType {
    @Override
    public String getName() {
        return "INVISMT";
    }

    @Override
    public String getInfo() {
        return "Interactive SMT Solver wraps various SMT-Solvers";
    }

    @Override
    public String getDefaultSolverParameters() {
        return "-in";
    }

    @Override
    public String getDefaultSolverCommand() {
        return "invismt";
    }

    @Override
    public String getVersionParameter() {
        return "--version";
    }

    @Override
    public String[] getSupportedVersions() {
        return new String[] { "1.0" };
    }

    @Override
    public String getRawVersion() {
        if (isInstalled(true)) {
            return VersionChecker.INSTANCE.getVersionFor(getSolverCommand(), getVersionParameter());
        } else {
            return null;
        }
    }
}
