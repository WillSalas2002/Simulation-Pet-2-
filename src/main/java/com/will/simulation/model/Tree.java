package com.will.simulation.model;

public class Tree extends Entity {

    public Tree() {
        sign = "\uD83C\uDF32";
    }

    private Tree(Tree target) {
        super(target);
    }

    @Override
    public Entity clone() {
        return new Tree(this);
    }
}
