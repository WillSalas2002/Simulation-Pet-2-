package com.will.simulation.action.spawn;

import com.will.simulation.World;
import com.will.simulation.model.Rock;

public class RockSpawnAction extends SpawnEntityAction<Rock> {
    public RockSpawnAction(World world) {
        super(world, new Rock());
        rate = world.getHeight() * world.getWidth() * 10 / 100;
    }
}
