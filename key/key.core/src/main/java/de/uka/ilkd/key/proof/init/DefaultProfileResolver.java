This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.proof.init;

/**
 * Instances of this class are used to get a default {@link Profile} instance.
 * <p>
 * Instances are created once via {@link ProofInitServiceUtil#getDefaultProfile(String)}
 * and reused all the time. This means that {@link DefaultProfileResolver} are singletons and should
 * not have a state.
 *
 * @author Martin Hentschel
 */
public interface DefaultProfileResolver {
    /**
     * Returns the profile name.
     *
     * @return The profile name.
     */
    public String getProfileName();

    /**
     * Returns the default {@link Profile} instance.
     *
     * @return The default {@link Profile} instance.
     */
    public Profile getDefaultProfile();
}
