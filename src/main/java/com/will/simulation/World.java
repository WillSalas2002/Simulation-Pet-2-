package com.will.simulation;

import com.will.simulation.model.*;

import java.util.*;

public class World {
    private final int height;
    private final int width;
    private final Random random = new Random();
    private final HashMap<Coordinate, Entity> worldMap = new HashMap<>();
    private final Entity[] entitiesPool = new Entity[]{new Rock(), new Tree(), new Grass(), new Herbivore(), new Predator()};

    public World(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public List<Coordinate> findAllCreatureCoordinates() {
        List<Coordinate> coordinates = new ArrayList<>();
        coordinates.addAll(findEntityCoordinatesByType(Herbivore.class));
        coordinates.addAll(findEntityCoordinatesByType(Predator.class));
        return coordinates;
    }

    public int getEntityQuantityByType(Class<? extends Entity> clazz) {
        return findEntityCoordinatesByType(clazz).size();
    }

    private List<Coordinate> findEntityCoordinatesByType(Class<? extends Entity> clazz) {
        List<Coordinate> entityCoordinates = new ArrayList<>();
        for (Map.Entry<Coordinate, Entity> entry : worldMap.entrySet()) {
            Entity entity = entry.getValue();
            if (entity.getClass() == clazz) {
                entityCoordinates.add(entity.getCoordinate());
            }
        }
        return entityCoordinates;
    }

    public Entity findEntityByCoordinate(Coordinate coordinate) {
        return worldMap.get(coordinate);
    }

    public void placeEntity(Coordinate coordinate, Entity entity) {
        entity.setCoordinate(coordinate);
        worldMap.put(coordinate, entity);
    }

    public void removeEntity(Coordinate coordinate) {
        worldMap.remove(coordinate);
    }

    public Coordinate getRandomEmptyCoordinate() {
        Coordinate coordinate;
        do {
            int y = random.nextInt(height);
            int x = random.nextInt(width);
            coordinate = new Coordinate(x, y);
        } while (findEntityByCoordinate(coordinate) != null);
        return coordinate;
    }

    public Entity getNewInstanceOfRandomEntity() {
        return entitiesPool[random.nextInt(entitiesPool.length)].clone();
    }

    public Entity getNewInstanceOfEntityByType(Class<? extends Entity> clazz) {
        for (Entity entity : entitiesPool) {
            if (entity.getClass() == clazz) {
                return entity.clone();
            }
        }
        return null;
    }

    public boolean isCellEmpty(Coordinate coordinate) {
        return !worldMap.containsKey(coordinate);
    }

    public boolean isGameFinished() {
        return findEntityCoordinatesByType(Herbivore.class).isEmpty();
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
