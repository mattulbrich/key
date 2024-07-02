This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.gui.extension.impl;

import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

import de.uka.ilkd.key.settings.AbstractPropertiesSettings;

public class ExtensionSettings extends AbstractPropertiesSettings {
    public final static String KEY_DISABLED = "[Extensions]disabled";
    private final PropertyEntry<Set<String>> forbiddenClasses =
        createStringSetProperty(KEY_DISABLED, "");

    public Collection<String> getForbiddenClasses() {
        return forbiddenClasses.get();
    }

    public void setForbiddenClasses(Collection<String> seq) {
        forbiddenClasses.set(new TreeSet<>(seq));
    }

    public PropertyEntry<Set<String>> forbiddenClasses() {
        return forbiddenClasses;
    }


    public void setForbiddenClass(Class type, boolean activated) {
        String text = type.getName();
        Collection<String> classes = getForbiddenClasses();
        if (activated) {
            classes.remove(text);
        } else {
            if (!classes.contains(text))
                classes.add(text);
        }
        setForbiddenClasses(classes);
    }
}
