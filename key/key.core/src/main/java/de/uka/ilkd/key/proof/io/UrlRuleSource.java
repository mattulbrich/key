This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.proof.io;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.StandardCharsets;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.IntStream;

public class UrlRuleSource extends RuleSource {

    private final URL url;
    private final long numberOfBytes;

    UrlRuleSource(final URL url) {
        this.url = url;
        if ("file".equals(url.getProtocol())) {
            numberOfBytes = new File(url.getFile()).length();
        } else {
            numberOfBytes = countBytesByReadingStream();
        }
    }

    private long countBytesByReadingStream() {
        try {
            final InputStream input = url.openStream();
            long localNumberOfBytes = 0;
            for (int readValue = input.read(); readValue != -1; localNumberOfBytes++, readValue =
                input.read());
            input.close();
            return localNumberOfBytes;
        } catch (final IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public int getNumberOfBytes() {
        return (int) numberOfBytes;
    }

    @Override
    public File file() {
        return new File(url.getFile());
    }

    @Override
    public URL url() {
        return url;
    }

    @Override
    public String getExternalForm() {
        return url.toExternalForm();
    }

    @Override
    public InputStream getNewStream() {
        try {
            return url.openStream();
        } catch (final IOException exception) {
            throw new RuntimeException("Error while reading rules.", exception);
        }
    }

    @Override
    public String toString() {
        return url.toString();
    }

    @Override
    public CharStream getCharStream() throws IOException {
        try (ReadableByteChannel channel = Channels.newChannel(getNewStream())) {
            return CharStreams.fromChannel(
                channel,
                StandardCharsets.UTF_8,
                4096,
                CodingErrorAction.REPLACE,
                url.toString(),
                -1);
        }
    }
}
