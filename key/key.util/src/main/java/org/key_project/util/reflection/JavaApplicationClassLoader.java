This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package org.key_project.util.reflection;

import java.util.ServiceLoader;

/**
 * An {@link IClassLoader} implementation for Java Applications.
 * <p>
 * In a Java Application all {@link Class}es are loaded by the same {@link ClassLoader}
 * and thus the Java API can be used directly to realize the functionality.
 *
 * @author Martin Hentschel
 */
public class JavaApplicationClassLoader implements IClassLoader {
    /**
     * {@inheritDoc}
     */
    @Override
    public Class<?> getClassforName(String className) throws ClassNotFoundException {
        return Class.forName(className);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <S> Iterable<S> loadServices(Class<?> contextClass, Class<S> service) {
        return ServiceLoader.load(service);
    }
}
