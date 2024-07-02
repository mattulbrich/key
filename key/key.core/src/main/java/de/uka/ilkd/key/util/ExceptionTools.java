This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.util;

import java.net.MalformedURLException;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import de.uka.ilkd.key.parser.Location;
import de.uka.ilkd.key.parser.proofjava.ParseException;
import de.uka.ilkd.key.parser.proofjava.Token;
import de.uka.ilkd.key.util.parsing.HasLocation;

import org.antlr.runtime.RecognitionException;

/**
 * Various utility methods related to exceptions.
 *
 * @author bruns
 * @since 2.4.0
 */
public final class ExceptionTools {

    private ExceptionTools() {
    }

    /**
     * Tries to resolve the location (i.e., file name, line, and column)
     * from a parsing exception.
     * Result may be null.
     *
     * @param exc the Throwable to extract the Location from
     * @return the Location stored inside the Throwable or null if no such can be found
     * @throws MalformedURLException if the no URL can be parsed from the String stored
     *         inside the given Throwable can not be successfully converted to a URL and thus
     *         no Location can be created
     */
    public static @Nullable Location getLocation(@Nonnull Throwable exc)
            throws MalformedURLException {
        Location location = null;
        if (exc instanceof HasLocation) {
            return ((HasLocation) exc).getLocation();
        } else if (exc instanceof RecognitionException) {
            location = getLocation((RecognitionException) exc);
        } else if (exc instanceof ParseException) {
            location = getLocation((ParseException) exc);
        }

        if (location == null && exc.getCause() != null) {
            location = getLocation(exc.getCause());
        }

        return location;
    }

    @Nullable
    private static Location getLocation(ParseException exc) throws MalformedURLException {
        // JavaCC has 1-based column numbers
        Token token = exc.currentToken;
        return token == null ? null
                : new Location("", token.next.beginLine, token.next.beginColumn);
    }


    @Nullable
    private static Location getLocation(RecognitionException exc) throws MalformedURLException {
        // ANTLR 3 - Recognition Exception.
        if (exc.input != null) {
            // ANTLR has 0-based column numbers, hence +1.
            return new Location(exc.input.getSourceName(),
                exc.line, exc.charPositionInLine + 1);
        }
        return null;
    }

}
