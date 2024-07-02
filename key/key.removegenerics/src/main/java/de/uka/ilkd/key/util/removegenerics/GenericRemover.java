This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.util.removegenerics;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import de.uka.ilkd.key.util.removegenerics.monitor.GenericRemoverMonitor;

import recoder.java.CompilationUnit;
import recoder.java.PackageSpecification;
import recoder.java.reference.PackageReference;

public class GenericRemover extends AbstractGenericRemover {
    private File outDir = new File(".");

    public GenericRemover(GenericRemoverMonitor monitor) {
        super(monitor);
    }

    public File getOutDir() {
        return outDir;
    }

    public void setOutDir(File outDir) {
        this.outDir = outDir;
    }

    @Override
    protected void saveModifiedCompilationUnit(CompilationUnit cu, String filename)
            throws IOException {
        // determine target subdirectory with trailing '/'
        File targetdir;
        PackageSpecification packageSpecification = cu.getPackageSpecification();
        if (packageSpecification != null) {
            String pack = toString(packageSpecification.getPackageReference());
            String subdir = pack.replace('.', File.separatorChar);
            targetdir = new File(outDir, subdir);
        } else {
            targetdir = outDir;
        }

        // retrieve filename
        File outFile = new File(targetdir, filename);

        // make directory if not existent
        targetdir.mkdirs();

        GenericResolutionTransformation.debugOut("output file", outFile);

        Writer w = new FileWriter(outFile);
        w.write(cu.toSource());
        w.close();
    }

    /**
     * make a string out of a packageReference.
     *
     * For some reason {@link PackageReference#toSource()} does not work here.
     *
     * @param packageReference reference to make string of, not null
     * @return a string, possibly with dots.
     */
    private String toString(PackageReference packageReference) {

        String ret = packageReference.getIdentifier().getText();
        packageReference = packageReference.getPackageReference();

        while (packageReference != null)
            do {
                ret = packageReference.getIdentifier().getText() + "." + ret;
                packageReference = packageReference.getPackageReference();
            } while (packageReference != null);

        return ret;
    }
}
