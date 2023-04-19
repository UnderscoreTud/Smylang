package me.tud.smylang.lang.lexer;

import me.tud.smylang.lang.Grid;

import java.util.LinkedList;

public class LexicalAnalyzer implements Cloneable {

    private final String data;
    private int pointer = 0;

    public LexicalAnalyzer(String data) {
        this.data = data.replace(" ", "");
    }

    public Grid readGrid() {
        int column, row;
        if ((column = readNumber()) >= 0) {
            offset(1);
            row = readNumber();
            if (column < 1 || row < 1)
                throw new RuntimeException("The length of column or row has to be at least 1");
        } else {
            column = row = 100;
        }
        return new Grid(column, row);
    }

    public LinkedList<TokenType> readAllTokens() {
        LinkedList<TokenType> tokenTypes = new LinkedList<>();
        do {
            tokenTypes.add(nextToken());
        } while (tokenTypes.getLast() != TokenType.EOF);
        return tokenTypes;
    }

    private TokenType nextToken() {
        for (TokenType type : TokenType.values()) {
            if (type.parser.parse(this))
                return type;
        }
        throw new RuntimeException("Unexpected character: '" + peek(0) + '\'');
    }

    private int readNumber() {
        int i = 0;
        char ch;
        StringBuilder builder = new StringBuilder();
        while (hasNext(i) && Character.isDigit(ch = peek(i++)))
            builder.append(ch);
        try {
            int number = Integer.parseInt(builder.toString());
            offset(i - 1);
            return number;
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public char next() {
        return data.charAt(pointer++);
    }

    public char peek(int offset) {
        return data.charAt(pointer + offset);
    }

    public void offset(int amount) {
        pointer += amount;
    }

    public boolean hasNext() {
        return hasNext(0);
    }

    public boolean hasNext(int offset) {
        return data.length() > pointer + offset;
    }

    @Override
    public LexicalAnalyzer clone() {
        try {
            return (LexicalAnalyzer) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

}
