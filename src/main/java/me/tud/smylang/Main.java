package me.tud.smylang;

import me.tud.smylang.lang.Interpreter;
import me.tud.smylang.lang.lexer.LexicalAnalyzer;

import java.io.*;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) throws IOException {
        String helloWorld;
        try (FileInputStream stream = new FileInputStream(Path.of("src/main/resources/HelloWorld.smyl").toAbsolutePath().toFile())) {
            helloWorld = new String(stream.readAllBytes());
        }
        LexicalAnalyzer lexer = new LexicalAnalyzer(helloWorld);
        Interpreter interpreter = new Interpreter(lexer.readGrid(), lexer.readAllTokens());
        interpreter.interpret();
        interpreter.run();
        interpreter.getUniverse().visualizeGrid();
    }

}
