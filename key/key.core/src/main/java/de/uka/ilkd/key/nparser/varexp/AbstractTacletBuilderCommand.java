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
 * Simple default implementation for {@link TacletBuilderCommand}.
 *
 * @author Alexander Weigl
 * @version 1 (12/9/19)
 */
public abstract class AbstractTacletBuilderCommand implements TacletBuilderCommand {
    private final @Nonnull String triggerName;
    private final @Nonnull ArgumentType[] argumentsTypes;

    /**
     * Construct this class with the parameters for {@link #isSuitableFor(String)} and
     * {@link #getArgumentTypes()}.
     *
     * @param triggerName the name of this command.
     * @param argumentsTypes the argument type of this command.
     */
    public AbstractTacletBuilderCommand(@Nonnull String triggerName,
            @Nonnull ArgumentType... argumentsTypes) {
        this.triggerName = triggerName;
        this.argumentsTypes = argumentsTypes;
    }

    @Override
    public boolean isSuitableFor(@Nonnull String name) {
        if (triggerName.equalsIgnoreCase(name)) {
            return true;
        }
        if (name.startsWith("\\")) // handling leading backslashes
            return isSuitableFor(name.substring(1));
        return false;
    }

    @Override
    public ArgumentType[] getArgumentTypes() {
        return argumentsTypes;
    }
}
