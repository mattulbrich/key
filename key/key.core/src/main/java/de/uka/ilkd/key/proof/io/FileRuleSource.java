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
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;
import javax.annotation.Nonnull;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;

public class FileRuleSource extends RuleSource {

    /**
     * The non-<code>null</code> reference to the file from which rules are
     * read.
     */
    protected @Nonnull final File ruleFile;

    private long numberOfChars;

    FileRuleSource(File ruleFile) {
        this.ruleFile = Objects.requireNonNull(ruleFile);
        numberOfChars = ruleFile.length();
    }

    @Override
    public int getNumberOfBytes() {
        return (int) numberOfChars;
    }

    @Override
    public @Nonnull File file() {
        return ruleFile;
    }

    @Override
    public URL url() throws IOException {
        return file().toURI().toURL();
    }

    @Override
    public String getExternalForm() {
        try {
            return ruleFile.toURI().toURL().toExternalForm();
        } catch (final MalformedURLException exception) {
            // should not be thrown
            throw new RuntimeException(exception);
        }
    }

    @Override
    public InputStream getNewStream() {
        try {
            return new BufferedInputStream(new FileInputStream(ruleFile));
        } catch (final FileNotFoundException exception) {
            throw new RuntimeException("Error while opening a file stream to " + ruleFile,
                exception);
        }
    }

    @Override
    public String toString() {
        return ruleFile.toString();
    }

    @Override
    public CharStream getCharStream() throws IOException {
        return CharStreams.fromFileName(ruleFile.getAbsolutePath());
    }
}
