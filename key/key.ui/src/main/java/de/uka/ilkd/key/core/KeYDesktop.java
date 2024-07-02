This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.core;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;

/**
 * This is the interface to the desktop of the operating system.
 * It should be used instead of {@link Desktop}, because the behavior
 * is different in Eclipse.
 *
 * @author Martin Hentschel
 * @see Main#getKeyDesktop()
 * @see DefaultKeYDesktop
 */
public interface KeYDesktop {
    /**
     * Checks if editing {@link File}s is supported.
     *
     * @return {@code true} is supported, {@code false} is not supported.
     */
    public boolean supportsEdit();

    /**
     * Open the given {@link File} for editing purpose.
     *
     * @param file The {@link File} to open.
     * @throws IOException Occurred Exception.
     */
    public void edit(File file) throws IOException;

    /**
     * Checks if opening {@link File}s is supported.
     *
     * @return {@code true} is supported, {@code false} is not supported.
     */
    public boolean supportsOpen();

    /**
     * Open the given {@link File} for viewing purpose.
     *
     * @param file The {@link File} to open.
     * @throws IOException Occurred Exception.
     */
    public void open(File file) throws IOException;

    /**
     * Checks if browsing {@link URI}s is supported.
     *
     * @return {@code true} is supported, {@code false} is not supported.
     */
    public boolean supportsBrowse();

    /**
     * Opens the given {@link URI}.
     *
     * @param uri The {@link URI} to open.
     * @throws IOException Occurred Exception.
     */
    public void browse(URI uri) throws IOException;
}
