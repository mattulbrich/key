This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package org.key_project.ui.interactionlog.model.builtin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import de.uka.ilkd.key.proof.Node;
import de.uka.ilkd.key.rule.LoopContractInternalBuiltInRuleApp;

/**
 * @author Alexander Weigl
 * @version 1 (09.12.18)
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class LoopContractInternalBuiltInRuleInteraction extends BuiltInRuleInteraction {
    private static final long serialVersionUID = 1L;

    public LoopContractInternalBuiltInRuleInteraction() {
    }

    public LoopContractInternalBuiltInRuleInteraction(LoopContractInternalBuiltInRuleApp app,
            Node node) {
    }
}
