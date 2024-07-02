This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.proof.runallproofs.performance;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

/**
 * A table in which data is stored during a
 * {@link RunAllProofsTestWithComputeCostProfiling} test run.
 */
public class DataRecordingTable implements AutoCloseable {

    /**
     * @param description
     *        A description of the data stored in the table.
     */
    DataRecordingTable(File location, String[] columns, String description) {
        this.location = location;
        this.columns = columns;

        boolean exists = location.exists();

        try {
            w = new PrintWriter(
                new FileOutputStream(location, true /* append = true */));
            if (!exists) {
                // First line will be the table description
                w.println("# " + description);
                // Second line will be a list of columns.
                StringBuilder sb = new StringBuilder("#");
                for (String s : columns) {
                    sb.append(" " + s);
                }
                w.println(sb);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private final PrintWriter w;

    @Override
    public void close() throws Exception {
        w.close();
    }

    /**
     * The file to which the recorded data is written.
     */
    final File location;

    /**
     * The table columns.
     */
    final String[] columns;

    public void writeComment(String comment) {
        w.println("# " + comment);
    }

    /*
     * Write a row to the table file. Column entries are specified via map,
     * which maps: columnName -> columnValue
     */
    public void writeRow(Object... lineData) {
        if (lineData.length != columns.length) {
            throw new RuntimeException(
                "Incorrect number of column values specified.\n" + "Expected: " + columns.length
                    + "\n" + "Actual number of columns specified: " + lineData.length);
        }

        /*
         * Start each line with one space so that they are indented at the same
         * level as comments, starting with "#".
         */
        StringBuilder line = new StringBuilder(" ");

        for (int i = 0; i < lineData.length; i++) {
            line.append(String.format(" %1$" + columns[i].length() + "s", lineData[i]));
        }

        w.println(line);
    }

}
