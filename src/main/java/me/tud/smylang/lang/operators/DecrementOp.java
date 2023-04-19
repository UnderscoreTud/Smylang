package me.tud.smylang.lang.operators;

import me.tud.smylang.lang.Universe;

public class DecrementOp implements Operator {

    @Override
    public void run(Universe universe) {
        universe.setCurrentCell(universe.getCurrentCell() - 1);
    }

}
