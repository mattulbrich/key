This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.java;

import de.uka.ilkd.key.java.statement.MethodFrame;
import de.uka.ilkd.key.logic.ProgramPrefix;

public class ProgramPrefixUtil {

    public static class ProgramPrefixInfo {
        private final int length;
        private final MethodFrame mf;

        public ProgramPrefixInfo(int length, MethodFrame mf) {
            this.length = length;
            this.mf = mf;
        }

        public int getLength() {
            return length;
        }

        public MethodFrame getInnerMostMethodFrame() {
            return mf;
        }
    }

    public static ProgramPrefixInfo computeEssentials(ProgramPrefix prefix) {
        int length = 1;
        MethodFrame mf = (MethodFrame) (prefix instanceof MethodFrame ? prefix : null);
        while (prefix.hasNextPrefixElement()) {
            prefix = prefix.getNextPrefixElement();
            if (prefix instanceof MethodFrame) {
                mf = (MethodFrame) prefix;
            }
            length++;
        }
        return new ProgramPrefixUtil.ProgramPrefixInfo(length, mf);
    }

}
