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
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import de.uka.ilkd.key.util.removegenerics.monitor.GenericRemoverMonitor;

import recoder.io.DataFileLocation;
import recoder.io.DataLocation;
import recoder.java.CompilationUnit;

public class PreviewGenericRemover extends AbstractGenericRemover {
    private final Map<File, String> resultMap = new HashMap<File, String>();

    public PreviewGenericRemover(GenericRemoverMonitor monitor) {
        super(monitor);
    }

    @Override
    protected void saveModifiedCompilationUnit(CompilationUnit cu, String filename)
            throws IOException {
        DataLocation location = cu.getDataLocation();
        assert location instanceof DataFileLocation;
        DataFileLocation fileLocation = (DataFileLocation) location;
        resultMap.put(fileLocation.getFile(), cu.toSource());
    }

    public Map<File, String> getResultMap() {
        return resultMap;
    }
}
