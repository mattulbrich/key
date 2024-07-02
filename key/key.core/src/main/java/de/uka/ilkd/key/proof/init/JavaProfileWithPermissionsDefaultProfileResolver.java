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
 * A {@link DefaultProfileResolver} which returns {@link JavaProfile#defaultInstancePermissions}.
 *
 * @author Martin Hentschel
 */
public class JavaProfileWithPermissionsDefaultProfileResolver implements DefaultProfileResolver {
    /**
     * {@inheritDoc}
     */
    @Override
    public String getProfileName() {
        return JavaProfile.NAME_WITH_PERMISSIONS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Profile getDefaultProfile() {
        return JavaProfile.getDefaultInstance(true);
    }
}
