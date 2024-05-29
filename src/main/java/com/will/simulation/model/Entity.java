package com.will.simulation.model;

import com.will.simulation.Coordinate;

public abstract class Entity {

    protected String sign;
    protected Coordinate coordinate;

    public Entity() {
    }

    public Entity(Entity target) {
        if (target != null) {
            this.sign = target.sign;
            this.coordinate = target.coordinate;
        }
    }

    public abstract Entity clone();

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    @Override
    public String toString() {
        return sign;
    }
}
