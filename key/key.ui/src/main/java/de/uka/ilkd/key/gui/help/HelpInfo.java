This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.gui.help;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Alexander Weigl
 * @version 1 (10.04.19)
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE })
/**
 * Annotate the help page for your component.
 *
 * @see HelpFacade
 */
public @interface HelpInfo {
    /**
     * The relative part of the URL to the {@link HelpFacade#HELP_BASE_URL}.
     *
     * @return non-null string
     */
    public String path() default "";
}
