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
                eatTargetEntity(world, targetCoordinate);
                this.life += CALORIC_VALUE;
            } else {
                moveTowardsTargetEntity(world, targetCoordinate);
            }
        } else {
            this.life -= STARVATION_VALUE;
            if (this.life <= 0) {
                world.removeEntity(this.coordinate);
            }
        }
    }
}
