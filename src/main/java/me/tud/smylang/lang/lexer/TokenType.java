package me.tud.smylang.lang.lexer;

import me.tud.smylang.lang.Direction;
import me.tud.smylang.lang.Universe;
import me.tud.smylang.lang.operators.Operator;

public enum TokenType {

    EOF(lexer -> !lexer.hasNext(), universe -> {}),
    PRINT_INT('!', Universe::printAsInt),
    PRINT_CHAR('?', Universe::printAsChar),
    UP(":)u", universe -> universe.face(Direction.UP)),
    RIGHT(":)r", universe -> universe.face(Direction.RIGHT)),
    DOWN(":)d", universe -> universe.face(Direction.DOWN)),
    LEFT(":)l", universe -> universe.face(Direction.LEFT)),
    MOVE('.', Universe::move),
    INCREMENT('+', universe -> universe.setCurrentCell(universe.getCurrentCell() + 1)),
    DECREMENT('-', universe -> universe.setCurrentCell(universe.getCurrentCell() - 1)),
    MULTIPLY('*', universe -> universe.setCurrentCell(universe.getCurrentCell() * universe.peek())),
    DIVIDE('/', universe -> universe.setCurrentCell(universe.getCurrentCell() / universe.peek())),
    MODULO('%', universe -> universe.setCurrentCell(universe.getCurrentCell() % universe.peek())),
    MEMORIZE('@', Universe::memorize),
    PUT_MEMORY('#', Universe::putMemory),
    GROUP_START('(', null),
    GROUP_END(')', null),
    LOOP_START('[', null),
    LOOP_END(']', null),
    ;

    private final Parser parser;
    private final Operator operator;

    TokenType(Parser parser, Operator operator) {
        this.parser = parser;
        this.operator = operator;
    }

    TokenType(char ch, Operator operator) {
        this(lexer -> {
            if (lexer.peek(0) == ch) {
                lexer.offset(1);
                return true;
            }
            return false;
        }, operator);
    }

    TokenType(String string, Operator operator) {
        this(string.toCharArray(), operator);
    }

    TokenType(char[] chars, Operator operator) {
        this(lexer -> {
            for (int i = 0; i < chars.length; i++) {
                if (lexer.peek(i) != chars[i])
                    return false;
            }
            lexer.offset(chars.length);
            return true;
        }, operator);
    }

    public boolean isSimple() {
        return operator != null;
    }

    public Parser getParser() {
        return parser;
    }

    public Operator getOperator() {
        return operator;
    }

    @FunctionalInterface
    interface Parser {

        boolean parse(LexicalAnalyzer lexer);

    }

}
