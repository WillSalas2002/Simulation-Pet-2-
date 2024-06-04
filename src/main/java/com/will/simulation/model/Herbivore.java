package com.will.simulation.model;

import com.will.simulation.Coordinate;
import com.will.simulation.World;

import java.util.List;

public class Herbivore extends Creature {

    public Herbivore() {
        sprite = "\uD83D\uDC11";
    }

    @Override
    public void makeMove(World world) {
        List<Coordinate> path = pathFinder.findPath(this, world, Grass.class);

        if (!path.isEmpty()) {
            Coordinate targetCoordinate = path.get(0);
            if (path.size() == 1) {
                Entity targetEntity = world.findEntityByCoordinate(targetCoordinate);
                eatTargetEntity(world, targetEntity);
                this.life += CALORIC_VALUE;
            } else {
                moveToCoordinate(world, targetCoordinate);
            }
        } else {
            this.life -= STARVATION_VALUE;
            if (this.life <= 0) {
                world.removeEntity(this.coordinate);
            }
        }
    }
}
