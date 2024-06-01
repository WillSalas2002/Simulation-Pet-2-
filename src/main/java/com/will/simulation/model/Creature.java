package com.will.simulation.model;

import com.will.simulation.Coordinate;
import com.will.simulation.PathFinder;
import com.will.simulation.BreadthFirstSearch;
import com.will.simulation.World;

public abstract class Creature extends Entity {
    protected PathFinder pathFinder = new BreadthFirstSearch();
    protected int speed = 1;
    protected int life = 100;
    protected final int CALORIC_VALUE = 15;
    protected final int STARVATION_VALUE = 15;

    public Creature() {
    }

    public Creature(Creature target) {
        super(target);
        if (target != null) {
            this.life = target.life;
            this.speed = target.speed;
            this.pathFinder = target.pathFinder;
        }
    }

    public abstract void makeMove(World world);

    protected void eatTargetEntity(World world, Coordinate targetEntityCoordinate) {
        world.removeEntity(targetEntityCoordinate);
        world.removeEntity(this.coordinate);
        world.placeEntity(targetEntityCoordinate, this);
    }

    protected void moveTowardsTargetEntity(World world, Coordinate targetCoordinate) {
        world.removeEntity(this.coordinate);
        world.placeEntity(targetCoordinate, this);
    }
}
