package com.will.simulation.model;

import com.will.simulation.Coordinate;
import com.will.simulation.World;

import java.util.List;

public class Predator extends Creature {

    private final int POWER_OF_ATTACK = 30;

    public Predator() {
        sprite = "\uD83D\uDC3A";
    }

    @Override
    public void makeMove(World world) {
        List<Coordinate> path = pathFinder.findPath(this, world, Herbivore.class);
        if (!path.isEmpty()) {
            Coordinate targetCoordinate = path.get(0);
            // target is near
            if (path.size() == 1) {
                Herbivore herbivore = (Herbivore) world.findEntityByCoordinate(targetCoordinate);
                herbivore.life -= POWER_OF_ATTACK;
                if (herbivore.life <= 0) {
                    eatTargetEntity(world, herbivore);
                } else {
                }
                // target is not near, need to make move towards herbivore
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
