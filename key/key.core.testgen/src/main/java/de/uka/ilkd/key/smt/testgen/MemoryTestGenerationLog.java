This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.smt.testgen;

import de.uka.ilkd.key.testgen.TestCaseGenerator;

/**
 * Implementation of {@link TestGenerationLog} which stores the log in memory.
 *
 * @author Martin Hentschel
 */
public class MemoryTestGenerationLog implements TestGenerationLog {
    /**
     * The {@link StringBuffer} which stores all the content.
     */
    private final StringBuffer sb = new StringBuffer();

    /**
     * {@inheritDoc}
     */
    @Override
    public void writeln(String string) {
        sb.append(string);
        sb.append(TestCaseGenerator.NEW_LINE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void write(String string) {
        sb.append(string);
        sb.append(TestCaseGenerator.NEW_LINE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void writeException(Throwable t) {
        sb.append(t.getMessage());
        sb.append(TestCaseGenerator.NEW_LINE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void testGenerationCompleted() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return sb.toString();
    }
}
