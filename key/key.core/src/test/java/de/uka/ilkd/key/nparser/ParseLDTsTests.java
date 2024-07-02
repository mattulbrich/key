This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.nparser;

import java.io.IOException;
import java.net.URL;

import de.uka.ilkd.key.java.Services;
import de.uka.ilkd.key.proof.init.JavaProfile;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

public class ParseLDTsTests {
    @Test
    public void testLDT() throws IOException {
        Services services = new Services(new JavaProfile());
        load(services, "/de/uka/ilkd/key/proof/rules/ldt.key");
    }

    @Test
    public void testSR() throws IOException {
        Services services = new Services(new JavaProfile());
        load(services, "/de/uka/ilkd/key/proof/rules/standardRules.key");
    }


    private void load(Services services, String resources) throws IOException {
        URL url = getClass().getResource(resources);
        Assumptions.assumeTrue(url != null && services != null);
        KeyIO io = new KeyIO(services);
        io.load(url).loadComplete();
    }
}
