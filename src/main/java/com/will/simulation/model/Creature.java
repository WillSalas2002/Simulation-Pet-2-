package com.will.simulation.model;

import com.will.simulation.Coordinate;
import com.will.simulation.PathFinder;
import com.will.simulation.BreadthFirstSearch;
import com.will.simulation.World;

public abstract class Creature extends Entity {
    protected PathFinder pathFinder = new BreadthFirstSearch();
    protected int life = 100;
    protected final int CALORIC_VALUE = 15;
    protected final int STARVATION_VALUE = 15;

    public Creature() {
    }

    public abstract void makeMove(World world);

    protected void eatTargetEntity(World world, Entity entity) {
        world.removeEntity(entity.coordinate);
        world.removeEntity(this.coordinate);
        world.placeEntity(entity.coordinate, this);
    }

    protected void moveToCoordinate(World world, Coordinate targetCoordinate) {
        world.removeEntity(this.coordinate);
        world.placeEntity(targetCoordinate, this);
    }
}
