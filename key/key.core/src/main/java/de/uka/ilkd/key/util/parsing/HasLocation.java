This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.util.parsing;

import java.net.MalformedURLException;
import javax.annotation.Nullable;

import de.uka.ilkd.key.parser.Location;

/**
 * This interface simply states, that an exception has locational information.
 *
 * @author Alexander Weigl
 * @version 1 (6/2/21)
 */
public interface HasLocation {
    /**
     * This method can be used to obtain the Location (1-based line and column!) of the exception.
     *
     * @return the location of the exception
     * @throws MalformedURLException if the URL for the location can not be created
     */
    @Nullable
    Location getLocation() throws MalformedURLException;
}
