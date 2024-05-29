package com.will.simulation.model;

import com.will.simulation.Coordinate;
import com.will.simulation.World;

import java.util.List;

public class Herbivore extends Creature {

    public Herbivore() {
        sign = "\uD83D\uDC11";
    }

    private Herbivore(Herbivore target) {
        super(target);
    }

    @Override
    public Creature clone() {
        return new Herbivore(this);
    }

    @Override
    public void makeMove(World world) {
        List<Coordinate> path = pathFinder.findPath(this, world, Grass.class);

        if (path != null) {
            Coordinate targetCoordinate = path.get(0);
            if (path.size() == 1) {
                // the grass is nearby
                world.removeEntity(targetCoordinate);
                world.removeEntity(this.getCoordinate());
                world.placeEntity(targetCoordinate,this);
                this.life += 30;
            } else {
                // grass is not near, need to move towards it
                world.removeEntity(this.coordinate);
                world.placeEntity(targetCoordinate, this);
            }
        }
    }
}
