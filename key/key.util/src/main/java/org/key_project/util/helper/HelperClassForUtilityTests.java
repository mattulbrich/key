This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package org.key_project.util.helper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class HelperClassForUtilityTests {
    public static final File RESOURCE_DIRECTORY = FindResources.getTestResourcesDirectory();

    /**
     * Creates a folder.
     *
     * @param folder The folder to create.
     * @return The created folder.
     */
    public static File createFolder(File folder) {
        if (!folder.exists())
            folder.mkdirs();
        /*
         * TestCase.assertEquals(!folder.exists(), folder.mkdirs());
         * TestCase.assertTrue(folder.exists());
         * TestCase.assertTrue(folder.isDirectory());
         */
        return folder;
    }

    /**
     * Creates a file
     *
     * @param file The file to create.
     * @param content The content to write to file.
     * @return The created file.
     * @throws IOException Occurred Exception.
     */
    public static File createFile(File file, String content) throws IOException {
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(content);
            // TestCase.assertTrue(file.exists());
            // TestCase.assertTrue(file.isFile());
            return file;
        }
    }
}
