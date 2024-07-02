This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.java.recoderext;

import java.util.List;

import de.uka.ilkd.key.speclang.njml.JmlTermFactory;
import de.uka.ilkd.key.util.MiscTools;

import recoder.java.Expression;

/**
 * This class handles all escape expressions in set-statements, that are registered
 * in JMLTranslator.jml2jdl
 *
 *
 * @author Kai Wallisch <kai.wallisch@ira.uka.de>
 */
public class RegisteredEscapeExpression extends EscapeExpression {

    /**
     * generated UID
     */
    private static final long serialVersionUID = 5400879603292633806L;

    private final String mapEscape;

    RegisteredEscapeExpression(String mapEscape, List<Expression> arguments) {
        super(JmlTermFactory.jml2jdl.get(mapEscape), arguments);
        this.mapEscape = mapEscape;
    }

    @Override
    public Expression deepClone() {
        return new RegisteredEscapeExpression(mapEscape, children);
    }

    @Override
    public String toSource() {
        return mapEscape + "(" + MiscTools.join(children, ",") + ")";
    }

}
