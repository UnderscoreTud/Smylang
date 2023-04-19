package me.tud.smylang.lang;

import me.tud.smylang.lang.lexer.TokenType;
import me.tud.smylang.lang.operators.FaceOp;
import me.tud.smylang.lang.operators.Operator;

import java.util.LinkedList;

public class Interpreter {

    private final Universe universe;
    private final LinkedList<TokenType> tokenTypes;
    private final LinkedList<Operator> operators;

    public Interpreter(Grid grid, LinkedList<TokenType> tokenTypes) {
        this.universe = new Universe(grid);
        this.tokenTypes = tokenTypes;
        this.operators = new LinkedList<>();
    }

    private TokenType currentToken() {
        return tokenTypes.getFirst();
    }

    private TokenType peek(int offset) {
        return tokenTypes.get(offset);
    }

    private void eat(TokenType expected) {
        if (currentToken() == expected)
            return;
    }

}
