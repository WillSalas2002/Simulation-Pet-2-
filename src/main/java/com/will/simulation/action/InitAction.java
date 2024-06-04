package com.will.simulation.action;

import com.will.simulation.World;
import com.will.simulation.factory.*;

public class InitAction extends ActionStrategy {

    public InitAction(World world) {
        super(world);
    }

    @Override
    public void executeAction() {
        EntitySpawnAction grassEntitySpawnAction = new EntitySpawnAction(world, new GrassFactory(), 5);
        EntitySpawnAction treeSpawnAction = new EntitySpawnAction(world, new TreeFactory(), 5);
        EntitySpawnAction rockSpawnAction = new EntitySpawnAction(world, new RockFactory(), 5);
        EntitySpawnAction herbivoreSpawnAction = new EntitySpawnAction(world, new HerbivoreFactory(), 5);
        EntitySpawnAction predatorSpawnAction = new EntitySpawnAction(world, new PredatorFactory(), 5);

        grassEntitySpawnAction.executeAction();
        treeSpawnAction.executeAction();
        rockSpawnAction.executeAction();
        herbivoreSpawnAction.executeAction();
        predatorSpawnAction.executeAction();
    }
}
