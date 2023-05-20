package me.tud.smylang.lang;

import me.tud.smylang.lang.lexer.TokenType;
import me.tud.smylang.lang.operators.GroupOp;
import me.tud.smylang.lang.operators.LoopOp;
import me.tud.smylang.lang.operators.Operator;

import java.util.LinkedList;
import java.util.List;

public class Interpreter {

    private final Universe universe;
    private final LinkedList<TokenType> tokenTypes;
    private final LinkedList<Operator> operators;
    private TokenType currentToken = null;

    public Interpreter(Grid grid, LinkedList<TokenType> tokenTypes) {
        this.universe = new Universe(grid);
        this.tokenTypes = tokenTypes;
        this.operators = new LinkedList<>();
    }

    public void interpret() {
        if (!operators.isEmpty())
            operators.clear();
        while (peek(0) != TokenType.EOF)
            operators.add(nextOperator());
    }

    public void run() {
        for (Operator operator : operators)
            operator.run(universe);
        System.out.println();
    }

    private Operator nextOperator() {
        if (next().isSimple())
            return simple();
        return switch (currentToken) {
            case GROUP_START -> group();
            case LOOP_START -> loop();
            default -> throw new UnsupportedOperationException("Unexpected token: " + currentToken);
        };
    }

    private Operator simple() {
        return currentToken.getOperator();
    }

    private GroupOp group() {
        List<Operator> operators = new LinkedList<>();
        while (peek(0) != TokenType.GROUP_END)
            operators.add(nextOperator());
        eat(TokenType.GROUP_END);
        return new GroupOp(operators);
    }

    private Operator loop() {
        List<Operator> operators = new LinkedList<>();
        while (peek(0) != TokenType.LOOP_END)
            operators.add(nextOperator());
        eat(TokenType.LOOP_END);
        if (peek(0) != TokenType.GROUP_START)
            throw new IllegalStateException("Expected a group operator, but got: " + peek(0));
        return new LoopOp(operators, nextOperator());
    }

    private TokenType next() {
        currentToken = tokenTypes.getFirst();
        return tokenTypes.pop();
    }

    private TokenType peek(int offset) {
        return tokenTypes.get(offset);
    }

    private void eat(TokenType expected) {
        if (next() != expected)
            throw new IllegalStateException("Expected " + expected + ", but got: " + currentToken);
    }

    public Universe getUniverse() {
        return universe;
    }

}
