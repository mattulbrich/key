This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.proof.io;

import java.io.*;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.StandardCharsets;
import java.util.zip.GZIPInputStream;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;

/**
 * This file rule source derivative wraps its input stream into a
 * {@link GZIPInputStream} thus allowing decompressing gnu-zipped proof files.
 *
 * @author tbormer on 12.02.16.
 */
public class GZipFileRuleSource extends FileRuleSource {

    /**
     * Instantiates a new file rule source.
     *
     * This is only instantiated from
     * {@link RuleSourceFactory#initRuleFile(File, boolean)}.
     *
     * @param ruleFile
     *        the file to read from.
     */
    GZipFileRuleSource(File ruleFile) {
        super(ruleFile);
    }

    @Override
    public InputStream getNewStream() {
        try {
            return new GZIPInputStream(new FileInputStream(ruleFile));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error while reading rules.", e);
        }
    }

    @Override
    public CharStream getCharStream() throws IOException {
        try (ReadableByteChannel channel = Channels.newChannel(getNewStream())) {
            return CharStreams.fromChannel(
                channel,
                StandardCharsets.UTF_8,
                4096,
                CodingErrorAction.REPLACE,
                file().toString(),
                -1);
        }
    }
}
