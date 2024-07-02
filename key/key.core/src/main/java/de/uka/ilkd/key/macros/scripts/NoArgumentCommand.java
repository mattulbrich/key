This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.macros.scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import de.uka.ilkd.key.macros.scripts.meta.DescriptionFacade;
import de.uka.ilkd.key.macros.scripts.meta.ProofScriptArgument;

/**
 * @author Alexander Weigl
 * @version 1 (28.03.17)
 */
public abstract class NoArgumentCommand implements ProofScriptCommand<Void> {
    @Override
    public List<ProofScriptArgument> getArguments() {
        return new ArrayList<>();
    }

    @Override
    public Void evaluateArguments(EngineState state,
            Map<String, String> arguments) {
        return null;
    }

    @Override
    public String getDocumentation() {
        return DescriptionFacade.getDocumentation(this);
    }
}
