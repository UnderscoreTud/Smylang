package me.tud.smylang.lang.operators;

import me.tud.smylang.lang.Universe;

public class PrintCharOp implements Operator {

    @Override
    public void run(Universe universe) {
        universe.printAsChar();
    }

}
