package com.will.simulation.action.spawn;

import com.will.simulation.World;
import com.will.simulation.model.Herbivore;

public class HerbivoreSpawnAction extends SpawnEntityAction<Herbivore> {
    public HerbivoreSpawnAction(World world) {
        super(world, new Herbivore());
        rate = world.getWorldMapArea() * 7 / 100;
    }
}
