package com.will.simulation.model;

public class Grass extends Entity {

    public Grass() {
        sign = "\uD83C\uDF40";
    }

    private Grass(Grass target) {
        super(target);
    }

    @Override
    public Entity clone() {
        return new Grass(this);
    }
}
