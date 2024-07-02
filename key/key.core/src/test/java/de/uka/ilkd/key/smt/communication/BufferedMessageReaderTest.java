This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.smt.communication;

import java.io.IOException;
import java.io.StringReader;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BufferedMessageReaderTest {

    @Test
    public void testSplitting() throws IOException {
        BufferedMessageReader r =
            new BufferedMessageReader(new StringReader("a\nC>C>b\n\nC>c"), new String[] { "C>" });
        assertEquals("a\n", r.readMessage());
        assertEquals("b\n\n", r.readMessage());
        assertEquals("c", r.readMessage());
        assertEquals("", r.drain());
    }

    @Test
    public void testEmptyStart() throws IOException {
        String[] delims = { "X", "Y" };
        BufferedMessageReader br =
            new BufferedMessageReader(new StringReader("XXXaXbYcYXY"), delims);
        assertEquals("a", br.readMessage());
        assertEquals("b", br.readMessage());
        assertEquals("c", br.readMessage());
        assertEquals(null, br.readMessage());
    }

    @Test
    public void testDrain() throws IOException {
        BufferedMessageReader r =
            new BufferedMessageReader(new StringReader("a\nC>C>b\n\nC>c"), new String[] { "C>" });
        assertEquals("a\n", r.readMessage());
        assertEquals("C>b\n\nC>c", r.drain());
    }

    @Test
    public void testXY() throws IOException {
        String[] delims = { "X", "Y" };
        BufferedMessageReader br = new BufferedMessageReader(new StringReader("aXbYc"), delims);
        assertEquals("a", br.readMessage());
        assertEquals("b", br.readMessage());
        assertEquals("c", br.readMessage());
        assertEquals(null, br.readMessage());
    }

    @Test
    public void testNewline() throws IOException {
        String[] delims = { "\n", "\r" };
        BufferedMessageReader br = new BufferedMessageReader(new StringReader("a\r\nb\nc"), delims);
        assertEquals("a", br.readMessage());
        assertEquals("b", br.readMessage());
        assertEquals("c", br.readMessage());
        assertEquals(null, br.readMessage());
    }

}
