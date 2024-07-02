This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.proof.runallproofs.performance;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import de.uka.ilkd.key.proof.runallproofs.RunAllProofsDirectories;

@SuppressWarnings("serial")
public class ProfilingDirectories extends RunAllProofsDirectories {

    public final File profilingDataDir;
    public final File ruleIndependentDataDir;
    public final File ruleDependentDataDir;
    public final File computeCostDataDir;
    public final File instantiateAppDataDir;
    private final File runDir;

    public ProfilingDirectories(Date runStart) {
        super(runStart);

        SimpleDateFormat format = new SimpleDateFormat(
            "dd.MMM_yyyy____HH:mm:ss");
        String date = format.format(runStart);
        runDir = new File(RUNALLPROOFS_DIR, "run-" + date);

        profilingDataDir = new File(runDir, "profilingData");
        ruleIndependentDataDir = new File(profilingDataDir, "ruleIndependentData");
        ruleIndependentDataDir.mkdirs();
        ruleDependentDataDir = new File(profilingDataDir, "ruleDependentData");
        computeCostDataDir = new File(ruleDependentDataDir, "computeCost");
        computeCostDataDir.mkdirs();
        instantiateAppDataDir = new File(ruleDependentDataDir, "instantiateApp");
        instantiateAppDataDir.mkdirs();
    }

}
