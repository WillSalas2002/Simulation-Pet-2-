package com.will.simulation;

import com.will.simulation.model.Creature;
import com.will.simulation.model.Entity;

import java.util.List;

public interface PathFinder {
    List<Coordinate> findPath(Creature creature, World world, Class<? extends Entity> targetClass);
}
