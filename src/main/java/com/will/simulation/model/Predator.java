package com.will.simulation.model;

import com.will.simulation.Coordinate;
import com.will.simulation.World;

import java.util.List;

public class Predator extends Creature {

    private final int powerOfAttack = 30;

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
            // Herbivore is near
            if (path.size() == 1) {
                if (world.findEntityByCoordinate(targetCoordinate) instanceof Herbivore herbivore) {
                    String format;
                    herbivore.life -= powerOfAttack;
                    // if Herbivore has 0 life left ---> remove it from the world map!
                    if (herbivore.life <= 0) {
                        // just logging
                        format = String.format("%s from coordinate %s ATE %s from coordinate %s", this, this.coordinate, herbivore, herbivore.coordinate);
                        System.out.println(format);

                        world.removeEntity(targetCoordinate);
                        world.removeEntity(this.coordinate);
                        world.placeEntity(targetCoordinate, this);
                    } else {
                        // just logging
                        format = String.format("%s from coordinate %s IS EATING %s from coordinate %s", this, this.coordinate, herbivore, herbivore.coordinate);
                        System.out.println(format);
                    }
                }
                // not nearby, need to make move towards herbivore
            } else {
                // just logging
                String format = String.format("%s from coordinate %s IS MOVING to coordinate %s", this, this.coordinate, targetCoordinate);
                System.out.println(format);

                world.removeEntity(this.getCoordinate());
                world.placeEntity(targetCoordinate, this);
            }
        } else {
            System.out.println(this + " from coordinate " + this.coordinate + " HAS NOWHERE to go.");
        }
    }
}
