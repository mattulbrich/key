This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.macros.scripts.meta;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This annotation is used for annotation of proof scripts arguments.
 *
 * @author Alexander Weigl
 * @version 1
 * @see Flag
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Option {
    /**
     * Name of the command line argument.
     *
     * @return a non-null string
     */
    String value();

    /**
     * Marks if this option has to be given on call of corresponding script command.
     *
     * @return true iff this field is required (not null)
     */
    boolean required() default true;

    /**
     * A help message for this argument.
     *
     * @return a non-null string
     */
    String help() default "";
}
