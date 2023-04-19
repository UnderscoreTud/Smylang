package me.tud.smylang.lang.operators;

import me.tud.smylang.lang.Universe;

public class MemorizeOp implements Operator {

    @Override
    public void run(Universe universe) {
        universe.memorize();
    }

}
