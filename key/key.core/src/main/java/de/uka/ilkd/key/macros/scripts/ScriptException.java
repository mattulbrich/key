This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.macros.scripts;

import java.net.URL;
import javax.annotation.Nullable;

import de.uka.ilkd.key.parser.Location;
import de.uka.ilkd.key.util.parsing.HasLocation;

public class ScriptException extends Exception implements HasLocation {

    private static final long serialVersionUID = -1200219771837971833L;

    private final Location location;

    public ScriptException() {
        super();
        this.location = null;
    }

    public ScriptException(String message, URL url, int line, int col, Throwable cause) {
        super(message, cause);
        if (url != null) {
            this.location = new Location(url, line, col);
        } else {
            this.location = null;
        }
    }

    public ScriptException(String message, URL url, int line, int col) {
        super(message);
        if (url != null) {
            this.location = new Location(url, line, col);
        } else {
            this.location = null;
        }
    }


    public ScriptException(String message) {
        super(message);
        this.location = null;
    }

    public ScriptException(Throwable cause) {
        super(cause);
        this.location = null;
    }

    public ScriptException(String message, Throwable cause) {
        super(message, cause);
        this.location = null;
    }

    @Nullable
    @Override
    public Location getLocation() {
        return location;
    }

}
