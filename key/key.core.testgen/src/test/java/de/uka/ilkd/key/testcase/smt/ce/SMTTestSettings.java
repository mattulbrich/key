This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.testcase.smt.ce;

import java.io.File;
import java.util.Collection;

import de.uka.ilkd.key.rule.Taclet;
import de.uka.ilkd.key.settings.NewSMTTranslationSettings;
import de.uka.ilkd.key.settings.PathConfig;
import de.uka.ilkd.key.settings.ProofDependentSMTSettings;
import de.uka.ilkd.key.smt.st.SolverType;

public class SMTTestSettings implements de.uka.ilkd.key.smt.SMTSettings {


    public long getGlobalBound() {
        return 0;
    }

    @Override
    public int getMaxConcurrentProcesses() {
        return 1;
    }

    @Override
    public int getMaxNumberOfGenerics() {
        return 2;
    }

    @Override
    public String getSMTTemporaryFolder() {
        return PathConfig.getKeyConfigDir()
            + File.separator + "smt_formula";
    }

    @Override
    public Collection<Taclet> getTaclets() {
        return null;
    }

    @Override
    public long getTimeout() {
        return 300000;
    }

    @Override
    public long getTimeout(SolverType type) {
        return getTimeout();
    }

    @Override
    public boolean instantiateNullAssumption() {
        return true;
    }

    @Override
    public boolean makesUseOfTaclets() {
        return false;
    }

    @Override
    public boolean useExplicitTypeHierarchy() {
        return false;
    }

    @Override
    public boolean useBuiltInUniqueness() {
        return false;
    }

    @Override
    public boolean useAssumptionsForBigSmallIntegers() {
        return false;
    }

    @Override
    public boolean useUninterpretedMultiplicationIfNecessary() {
        return false;
    }

    @Override
    public long getMaximumInteger() {

        return ProofDependentSMTSettings.getDefaultSettingsData().maxInteger;
    }

    @Override
    public long getMinimumInteger() {

        return ProofDependentSMTSettings.getDefaultSettingsData().minInteger;
    }

    @Override
    public String getLogic() {
        return "AUFLIA";
    }

    @Override
    public boolean checkForSupport() {
        return false;
    }

    @Override
    public long getIntBound() {
        return 3;
    }

    @Override
    public long getHeapBound() {
        return 3;
    }

    @Override
    public long getSeqBound() {
        return 3;
    }

    @Override
    public long getObjectBound() {
        return 3;
    }

    @Override
    public long getLocSetBound() {
        return 3;
    }

    @Override
    public boolean invarianForall() {
        return false;
    }

    @Override
    public NewSMTTranslationSettings getNewSettings() {
        return new NewSMTTranslationSettings();
    }


}
