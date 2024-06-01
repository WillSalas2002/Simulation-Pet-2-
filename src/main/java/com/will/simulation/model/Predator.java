package com.will.simulation.model;

import com.will.simulation.Coordinate;
import com.will.simulation.World;

import java.util.List;

public class Predator extends Creature {

    private final int POWER_OF_ATTACK = 30;

    public Predator() {
        sign = "\uD83D\uDC3A";
    }

    private Predator(Predator target) {
        super(target);
    }

    @Override
    public Creature clone() {
        return new Predator(this);
    }

    @Override
    public void makeMove(World world) {
        List<Coordinate> path = pathFinder.findPath(this, world, Herbivore.class);
        if (path != null) {
            Coordinate targetCoordinate = path.get(0);
            // target is near
            if (path.size() == 1) {
                Herbivore herbivore = (Herbivore) world.findEntityByCoordinate(targetCoordinate);
                herbivore.life -= POWER_OF_ATTACK;
                if (herbivore.life <= 0) {
                    System.out.printf("%s from coordinate %s ATE %s (%d) from coordinate %s \n", this, this.coordinate, herbivore, herbivore.life, herbivore.coordinate);
                    eatTargetEntity(world, targetCoordinate);
                } else {
                    System.out.printf("%s from coordinate %s IS EATING %s (%d) from coordinate %s \n", this, this.coordinate, herbivore, herbivore.life, herbivore.coordinate);
                }
                // target is not near, need to make move towards herbivore
            } else {
                System.out.printf("%s from coordinate %s IS MOVING to coordinate %s \n", this, this.coordinate, targetCoordinate);
                moveTowardsTargetEntity(world, targetCoordinate);
            }
        } else {
            System.out.printf("%s from coordinate %s HAS NOWHERE to go \n", this, this.coordinate);
            this.life -= STARVATION_VALUE;
            if (this.life <= 0) {
                world.removeEntity(this.coordinate);
            }
        }
    }
}
