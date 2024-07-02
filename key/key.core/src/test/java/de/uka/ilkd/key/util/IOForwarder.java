This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * A simple i/o forwarding thread which maps {@link InputStream}s to
 * {@link OutputStream}s.
 * <p>
 * Used to redirect i/o from {@link Process}es to system streams.
 * <p>
 * The class is active and the threads terminate as soon as the input stream is
 * at EOF.
 * <p>
 * NB: {@link ProcessBuilder#inheritIO()} would not work.
 *
 * @author Mattias Ulbrich
 */
public class IOForwarder extends Thread {

    private final InputStream from;
    private final OutputStream to;

    public IOForwarder(String type, InputStream from, OutputStream to) {
        super("IOForwarder - " + type);
        this.from = from;
        this.to = to;
    }

    /**
     * Forward the stdout and stderr streams of process to System.out and
     * System.err.
     * <p>
     * This method launches two new threads.
     *
     * @param process process whose output is to be forwarded.
     */
    public static void forward(Process process) {
        IOForwarder f2 = new IOForwarder("stdout", process.getInputStream(), System.out);
        f2.start();
        IOForwarder f3 = new IOForwarder("stderr", process.getErrorStream(), System.err);
        f3.start();
    }

    @Override
    public void run() {
        try {
            byte[] buffer = new byte[4096];
            int read;
            while ((read = from.read(buffer)) > 0) {
                to.write(buffer, 0, read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
