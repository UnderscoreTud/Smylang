package me.tud.smylang.lang.operators;

import me.tud.smylang.lang.Universe;

public class MoveOp implements Operator {

    @Override
    public void run(Universe universe) {
        universe.move();
    }

}
