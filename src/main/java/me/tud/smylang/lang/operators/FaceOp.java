package me.tud.smylang.lang.operators;

import me.tud.smylang.lang.Direction;
import me.tud.smylang.lang.Universe;

public class FaceOp implements Operator {

    private final Direction direction;

    public FaceOp(Direction direction) {
        this.direction = direction;
    }

    @Override
    public void run(Universe universe) {
        universe.face(direction);
    }

}
