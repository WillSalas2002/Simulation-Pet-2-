package com.will.simulation;

import com.will.simulation.model.*;

import java.util.*;

public class Action {
    private final World world;
    private final Random random = new Random();
    private final Entity[] entities = new Entity[]{new Rock(), new Tree(), new Grass(), new Herbivore(), new Predator()};

    public Action(World world) {
        this.world = world;
    }

    public void initActions() {
        for (int i = 0; i < world.getWidth() * world.getHeight() / 2; i++) {

            Coordinate randomCoordinate = getRandomCoordinate();
            // getting random entity and creating it with Prototype ---> no problem with coordinates when movement starts
            Entity randomEntity = entities[random.nextInt(entities.length)].clone();

            if (randomEntity instanceof Creature creature) {
                creature.setLife(120);
            }
            randomEntity.setCoordinate(randomCoordinate);
            world.addEntity(randomCoordinate, randomEntity);
        }
    }

    public void turnActions() {

        List<Coordinate> herbivoreCoordinates = world.findEntityCoordinates(Herbivore.class);
        List<Coordinate> predatorCoordinates = world.findEntityCoordinates(Predator.class);
        List<Coordinate> creatureCoordinate = new ArrayList<>();
        creatureCoordinate.addAll(herbivoreCoordinates);
        creatureCoordinate.addAll(predatorCoordinates);

        // Iterating over each creature and calling makeMove() method of it
        for (Coordinate coordinate : creatureCoordinate) {
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
            Coordinate randomCoordinate = getRandomCoordinate();
            Entity entity = entities[2].clone();
            entity.setCoordinate(randomCoordinate);
            world.addEntity(randomCoordinate, entity);
        }
    }

    private Coordinate getRandomCoordinate() {
        Coordinate coordinate;
        do {
            int y = random.nextInt(world.getHeight());
            int x = random.nextInt(world.getWidth());
            coordinate = new Coordinate(x, y);
        } while (world.findEntityByCoordinate(coordinate) != null);

        return coordinate;
    }
}
