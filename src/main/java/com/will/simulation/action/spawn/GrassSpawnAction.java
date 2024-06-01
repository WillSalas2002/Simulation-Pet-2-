package com.will.simulation.action.spawn;

import com.will.simulation.World;
import com.will.simulation.model.Grass;

public class GrassSpawnAction extends SpawnEntityAction<Grass> {
    public GrassSpawnAction(World world) {
        super(world, new Grass());
        rate = world.getWorldMapArea() * 15 / 100;
    }
}
