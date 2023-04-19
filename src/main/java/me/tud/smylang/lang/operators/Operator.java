package me.tud.smylang.lang.operators;

import me.tud.smylang.lang.Universe;

@FunctionalInterface
public interface Operator {

    void run(Universe universe);

}
