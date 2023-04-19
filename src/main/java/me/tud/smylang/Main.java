package me.tud.smylang;

import me.tud.smylang.lang.Interpreter;
import me.tud.smylang.lang.lexer.LexicalAnalyzer;

public class Main {

    public static void main(String[] args) {
        LexicalAnalyzer lexer = new LexicalAnalyzer("10,10[:)r+.:)l+.]");
        Interpreter interpreter = new Interpreter(lexer.readGrid(), lexer.readAllTokens());
    }

}
