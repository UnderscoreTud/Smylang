package me.tud.smylang.lang.lexer;

public enum TokenType {

    EOF(lexer -> !lexer.hasNext()),
    FACE(lexer -> {
        if (lexer.peek(0) == ':' && lexer.peek(1) == ')') {
            lexer.offset(2);
            return true;
        }
        return false;
    }),
    PRINT_INT('!'),
    PRINT_CHAR('?'),
    UP('u'),
    RIGHT('r'),
    DOWN('d'),
    LEFT('l'),
    MOVE('.'),
    INCREMENT('+'),
    DECREMENT('-'),
    MULTIPLY('*'),
    DIVIDE('/'),
    MODULO('%'),
    GROUP_START('('),
    GROUP_END(')'),
    LOOP_START('['),
    LOOP_END(']'),
    MEMORIZE('@'),
    PUT_MEMORY('#'),
    ;

    public final Parser parser;

    TokenType(Parser parser) {
        this.parser = parser;
    }

    TokenType(char ch) {
        this.parser = lexer -> {
            if (lexer.peek(0) == ch) {
                lexer.offset(1);
                return true;
            }
            return false;
        };
    }

    @FunctionalInterface
    interface Parser {

        boolean parse(LexicalAnalyzer lexer);

    }

}
