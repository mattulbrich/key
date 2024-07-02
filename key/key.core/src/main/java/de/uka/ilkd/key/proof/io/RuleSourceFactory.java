This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.proof.io;

import java.io.File;
import java.net.URL;

import de.uka.ilkd.key.proof.Proof;
import de.uka.ilkd.key.util.KeYResourceManager;

public class RuleSourceFactory {

    /**
     * Use this key to set a system property where rule resources have to be looked up.
     */
    public static final String STD_TACLET_DIR_PROP_KEY = "org.key_project.stdTacletDirectory";

    private static final String PATH_TO_RULES = "rules/";

    public static RuleSource fromDefaultLocation(final String ruleFileName) {
        String stdTacletDir = System.getProperty(STD_TACLET_DIR_PROP_KEY);
        if (stdTacletDir == null) {
            return fromBuiltInRule(ruleFileName);
        } else {
            return initRuleFile(new File(stdTacletDir, ruleFileName));
        }
    }

    public static RuleSource fromBuiltInRule(final String ruleFileName) {
        final URL u = KeYResourceManager.getManager().getResourceFile(Proof.class,
            PATH_TO_RULES + ruleFileName);
        if (u == null) {
            // a more specific exception type would probably be better
            throw new RuntimeException("Could not find rule file " + PATH_TO_RULES + ruleFileName);
        }
        return new UrlRuleSource(u);
    }

    public static RuleSource initRuleFile(final URL url) {
        return new UrlRuleSource(url);
    }

    public static RuleSource initRuleFile(final File file) {
        return initRuleFile(file, false);
    }

    /**
     * Initialise this object from a file
     *
     * @param file
     *        the non-<code>null</code> file reference
     * @param compressed
     *        <code>true</code> iff the file is gzip-compressed
     * @return the rule source read from the file.
     */
    public static RuleSource initRuleFile(final File file, boolean compressed) {
        if (compressed) {
            return new GZipFileRuleSource(file);
        } else {
            return new FileRuleSource(file);
        }
    }
}
