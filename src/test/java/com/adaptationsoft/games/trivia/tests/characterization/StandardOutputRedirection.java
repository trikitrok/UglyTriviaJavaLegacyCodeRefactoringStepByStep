package com.adaptationsoft.games.trivia.tests.characterization;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class StandardOutputRedirection {
    private ByteArrayOutputStream newOut;
    private PrintStream old_out;

    public StandardOutputRedirection(ByteArrayOutputStream newOut, PrintStream old_out) {
        super();
        this.newOut = newOut;
        this.old_out = old_out;
        System.setOut(new PrintStream(this.newOut));
    }

    public void reset() {
        System.setOut(old_out);
    }

    public String getRedirectedOutput() {
        return new String(newOut.toByteArray());
    }
}
