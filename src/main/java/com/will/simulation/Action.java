package com.will.simulation;

import com.will.simulation.model.*;

import java.util.*;

public class Action {
    private final World world;

    public Action(World world) {
        this.world = world;
    }

    public void initActions() {
        for (int i = 0; i < world.getWidth() * world.getHeight() / 2; i++) {

            Coordinate randomCoordinate = world.getRandomEmptyCoordinate();
            Entity randomEntity = world.getNewInstanceOfRandomEntity();

            world.placeEntity(randomCoordinate, randomEntity);
        }
    }

    public void turnActions() {

        List<Coordinate> creatureCoordinates = new ArrayList<>();

        List<Coordinate> herbivoreCoordinates = world.findEntityCoordinates(Herbivore.class);
        List<Coordinate> predatorCoordinates = world.findEntityCoordinates(Predator.class);
        creatureCoordinates.addAll(herbivoreCoordinates);
        creatureCoordinates.addAll(predatorCoordinates);

        // Iterating over each creature and calling makeMove() method of it
        for (Coordinate coordinate : creatureCoordinates) {
            Creature creature = (Creature) world.findEntityByCoordinate(coordinate);
            creature.makeMove(world);
        }
        // Increase grass quantity if there are few left
        int oneTenthOfMapSize = world.getHeight() * world.getWidth() / 10;
        List<Coordinate> grassCoordinates = world.findEntityCoordinates(Grass.class);

        if (grassCoordinates.size() < oneTenthOfMapSize) {
            addGrassToMap();
        }
    }

    private void addGrassToMap() {
        for (int i = 0; i < 5; i++) {
            Coordinate randomCoordinate = world.getRandomEmptyCoordinate();
            Entity entity = world.getNewInstanceOfEntityByType(Grass.class);
            world.placeEntity(randomCoordinate, entity);
        }
    }
}
