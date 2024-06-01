package com.will.simulation.action.spawn;

import com.will.simulation.World;
import com.will.simulation.model.Tree;

public class TreeSpawnAction extends SpawnEntityAction<Tree> {
    public TreeSpawnAction(World world) {
        super(world, new Tree());
        rate = world.getWorldMapArea() * 10 / 100;
    }
}
