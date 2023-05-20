package me.tud.smylang.lang.operators;

import me.tud.smylang.lang.Pointer;
import me.tud.smylang.lang.Universe;

import java.util.List;

public class LoopOp implements Operator {

    private final List<Operator> operators;
    private final Operator offset;

    public LoopOp(List<Operator> operators, Operator offset) {
        this.operators = operators;
        this.offset = offset;
    }

    @Override
    public void run(Universe universe) {
        Pointer original = universe.getPointer().clone();
        offset.run(universe);
        int times = universe.getCurrentCell();
        universe.getPointer().set(original);
        for (int i = 0; i < times; i++) {
            for (Operator operator : operators)
                operator.run(universe);
        }
    }

}
