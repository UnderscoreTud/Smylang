package me.tud.smylang.lang.operators;

import me.tud.smylang.lang.Universe;

import java.util.List;

public class GroupOp implements Operator {

    private final List<Operator> operators;

    public GroupOp(List<Operator> operators) {
        this.operators = operators;
    }

    @Override
    public void run(Universe universe) {
        for (Operator operator : operators)
            operator.run(universe);
    }

}
