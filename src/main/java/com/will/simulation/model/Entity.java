package com.will.simulation.model;

import com.will.simulation.Coordinate;

public abstract class Entity {

    protected String sprite;
    protected Coordinate coordinate;

    public Entity() {
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public String getSprite() {
        return sprite;
    }
}
