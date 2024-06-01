package com.will.simulation.action.spawn;

import com.will.simulation.World;
import com.will.simulation.model.Predator;

public class PredatorSpawnAction extends SpawnEntityAction<Predator> {
    public PredatorSpawnAction(World world) {
        super(world, new Predator());
        rate = world.getWorldMapArea() * 5 / 100;
    }
}
