package com.will.simulation;

import com.will.simulation.model.*;

public class Action {
    private final World world;

    public Action(World world) {
        this.world = world;
    }

    public void initActions() {
        for (int i = 0; i < world.getWidth() * world.getHeight() / 2; i++) {
            Coordinate randomCoordinate = world.generateRandomEmptyCoordinate();
            Entity randomEntity = world.getNewRandomEntity();
            world.placeEntity(randomCoordinate, randomEntity);
        }
    }

    public void turnActions() {
        for (Coordinate coordinate : world.findAllCreatureCoordinates()) {
            Creature creature = (Creature) world.findEntityByCoordinate(coordinate);
            creature.makeMove(world);
        }

        int oneTenthOfMapSize = world.getHeight() * world.getWidth() / 10;
        if (world.getEntityQuantityByType(Grass.class) < oneTenthOfMapSize) {
            addGrassToMap();
        }
    }

    private void addGrassToMap() {
        for (int i = 0; i < 5; i++) {
            Coordinate randomCoordinate = world.generateRandomEmptyCoordinate();
            Entity entity = world.getNewEntityByType(Grass.class);
            world.placeEntity(randomCoordinate, entity);
        }
    }
}
