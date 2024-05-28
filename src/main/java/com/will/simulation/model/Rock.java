package com.will.simulation.model;

public class Rock extends Entity {

    public Rock() {
        sign = "\uD83E\uDEA8";
    }

    private Rock(Rock target) {
        super(target);
    }

    @Override
    public Entity clone() {
        return new Rock(this);
    }
}
