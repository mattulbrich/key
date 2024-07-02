This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package org.key_project.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Helper functions for {@link String}s
 *
 * @author Alexander Weigl
 * @version 1 (29.03.19)
 */
public class Strings {
    /**
     * Checks whether a string contains another one as a whole word
     * (i.e., separated by whitespaces or a semicolon at the end).
     *
     * @param s string to search in
     * @param word string to be searched for
     */
    public static boolean containsWholeWord(String s, String word) {
        Pattern p = Pattern.compile("\\b" + word + "\\b");
        Matcher m = p.matcher(s);
        return m.find();
        /*
         * if (s == null || word == null) {
         * return false;
         * }
         * int i = -1;
         * final int wl = word.length();
         * while (true) {
         * i = s.indexOf(word, i + 1);
         * if (i < 0 || i >= s.length()) break;
         * if (i == 0 || Character.isWhitespace(s.charAt(i - 1))) {
         * if (i + wl == s.length() || Character.isWhitespace(s.charAt(i + wl)) || s.charAt(i + wl)
         * == ';') {
         * return true;
         * }
         * }
         * }
         * return false;
         */
    }


    /**
     * There are different kinds of JML markers.
     * See Section 4.4 "Annotation markers" of the JML reference manual.
     *
     * @param comment
     * @return
     */
    public static boolean isJMLComment(String comment) {
        try {
            return (comment.startsWith("/*@") || comment.startsWith("//@")
                    || comment.startsWith("/*+KeY@") || comment.startsWith("//+KeY@")
                    || (comment.startsWith("/*-") && !comment.substring(3, 6).equals("KeY")
                            && comment.contains("@"))
                    || (comment.startsWith("//-") && !comment.substring(3, 6).equals("KeY")
                            && comment.contains("@")));
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }
}
