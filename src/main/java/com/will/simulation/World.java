package com.will.simulation;

import com.will.simulation.model.*;

import java.util.*;

public class World {
    private final int height;
    private final int width;
    private final Map<Coordinate, Entity> worldMap = new HashMap<>();

    public World(int height, int width) {
        this.height = height;
        this.width = width;
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

    public boolean isCellEmpty(Coordinate coordinate) {
        return !worldMap.containsKey(coordinate);
    }

    public List<Coordinate> findAllCreatureCoordinates() {
        List<Coordinate> coordinates = new ArrayList<>();
        coordinates.addAll(findCoordinatesByEntityType(Herbivore.class));
        coordinates.addAll(findCoordinatesByEntityType(Predator.class));
        return coordinates;
    }

    public int getEntityQuantityByType(Class<? extends Entity> clazz) {
        return findCoordinatesByEntityType(clazz).size();
    }

    private List<Coordinate> findCoordinatesByEntityType(Class<? extends Entity> clazz) {
        List<Coordinate> entityCoordinates = new ArrayList<>();
        for (Map.Entry<Coordinate, Entity> entry : worldMap.entrySet()) {
            Entity entity = entry.getValue();
            if (entity.getClass() == clazz) {
                entityCoordinates.add(entity.getCoordinate());
            }
        }
        return entityCoordinates;
    }

    public int getWorldMapArea() {
        return width * height;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
