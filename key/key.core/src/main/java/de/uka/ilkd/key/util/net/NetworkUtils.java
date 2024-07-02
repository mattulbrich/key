This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.util.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;


public final class NetworkUtils {

    private static final URL KEY_URL = getURL("http://key-project.org/");
    // private static final URL LATEST_VERSION_URL =
    // getURL("http://key-project.org/download/latest");

    /**
     * Tests whether the KeY Project home page is
     * accessible over the internet.
     */
    public static boolean homePageAvailable() {
        BufferedReader in = null;
        try {
            final InputStreamReader isr = new InputStreamReader(KEY_URL.openStream());
            in = new BufferedReader(isr);
            in.close();
            return true;
        } catch (UnknownHostException e) {
            // this should usually happen
            return false;
        } catch (IOException e) {
            // something else (should not happen)
            e.printStackTrace();
            assert false;
            return false;
        } finally {
            if (in != null)
                try {
                    in.close();
                } catch (IOException e) {
                }
        }
    }

    // THIS METHOD PHONES HOME.
    // 1) It makes KeY freeze if key-project.org is unavailable or
    // the line is busy. (That has happened)
    // 2) It reveals information about who uses KeY (IP) though
    // we did not ask for permission.
    // /**
    // * Tries to read the latest stable version number of KeY
    // * from the KeY home page.
    // * It must be contained in file <a href="http://key-project.org/download/latest">
    // * download/latest</a> in a single line.
    // */
    // public static String getLatestVersion() {
    // BufferedReader in = null;
    // try {
    // in = new BufferedReader(new InputStreamReader(LATEST_VERSION_URL.openStream()));
    // // just read one single line
    // String version = in.readLine();
    // in.close();
    // return version;
    // } catch (IOException e) {
    // // something went wrong
    // if (in != null)
    // try {in.close();} catch (IOException e1) {}
    // return new String("0.0.0");
    // }
    // }

    /**
     * Create an URL without raising {@link MalformedURLException},
     * but {@link AssertionError} instead. Use with care.
     */
    public static URL getURL(String urlString) {
        try {
            return new URL(urlString);
        } catch (MalformedURLException e) {
            assert false;
            return null;
        }
    }
}
