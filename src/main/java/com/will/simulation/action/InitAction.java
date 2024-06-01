package com.will.simulation.action;

import com.will.simulation.World;
import com.will.simulation.action.spawn.*;
import com.will.simulation.model.*;

public class InitAction extends ActionStrategy {

    public InitAction(World world) {
        super(world);
    }

    @Override
    public void executeAction() {
        SpawnEntityAction<Grass> grassSpawnAction = new GrassSpawnAction(world);
        SpawnEntityAction<Tree> treeSpawnAction = new TreeSpawnAction(world);
        SpawnEntityAction<Rock> rockSpawnAction = new RockSpawnAction(world);
        SpawnEntityAction<Herbivore> herbivoreSpawnAction = new HerbivoreSpawnAction(world);
        SpawnEntityAction<Predator> predatorSpawnAction = new PredatorSpawnAction(world);

        for (int i = 0; i < grassSpawnAction.rate; i++) {
            grassSpawnAction.executeAction();
        }
        for (int i = 0; i < treeSpawnAction.rate; i++) {
            treeSpawnAction.executeAction();
        }
        for (int i = 0; i < rockSpawnAction.rate; i++) {
            rockSpawnAction.executeAction();
        }
        for (int i = 0; i < herbivoreSpawnAction.rate; i++) {
            herbivoreSpawnAction.executeAction();
        }
        for (int i = 0; i < predatorSpawnAction.rate; i++) {
            predatorSpawnAction.executeAction();
        }
    }
}
