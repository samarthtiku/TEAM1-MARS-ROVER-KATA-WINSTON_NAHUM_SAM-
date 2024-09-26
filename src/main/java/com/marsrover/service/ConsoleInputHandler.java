package com.marsrover.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInputHandler implements InputHandler {
    private final BufferedReader reader;

    public ConsoleInputHandler() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public String getInput() throws IOException {
        try {
            return reader.readLine();
        } catch (IOException e) {
            System.err.println("Error reading input: " + e.getMessage());
            throw e;
        }
    }

    public void close() throws IOException {
        reader.close();
    }
}
