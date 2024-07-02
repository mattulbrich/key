This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package org.key_project.util.lookup;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Marker annotations for setters or constructors to inject implementations.
 *
 * @author Alexander Weigl
 * @version 1 (13.01.19)
 *
 * @see Lookup#createInstance(Class)
 * @see Lookup#inject(Object)
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Inject {
}
