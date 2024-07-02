This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.nparser.varexp;

import javax.annotation.Nonnull;

/**
 * @author Alexander Weigl
 * @version 1 (12/9/19)
 */
public abstract class AbstractConditionBuilder
        extends AbstractTacletBuilderCommand
        implements ConditionBuilder {
    public AbstractConditionBuilder(@Nonnull String triggerName,
            @Nonnull ArgumentType... argumentsTypes) {
        super(triggerName, argumentsTypes);
    }
}
