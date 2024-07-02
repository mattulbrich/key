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
 * A simple checked exception which holds an location.
 *
 * @author Alexander Weigl
 * @version 1 (6/21/21)
 */
public class LocatableException extends RuntimeException implements HasLocation {
    private final Location location;

    public LocatableException(Location location) {
        this.location = location;
    }

    public LocatableException(String message, Location location) {
        super(message);
        this.location = location;
    }

    public LocatableException(String message, Throwable cause, Location location) {
        super(message, cause);
        this.location = location;
    }

    public LocatableException(Throwable cause, Location location) {
        super(cause);
        this.location = location;
    }

    public LocatableException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace, Location location) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.location = location;
    }

    @Nullable
    @Override
    public Location getLocation() throws MalformedURLException {
        return location;
    }
}
