package com.will.simulation;

import com.will.simulation.model.*;

import java.util.*;

public class World {
    private final int height;
    private final int width;
    private final HashMap<Coordinate, Entity> worldMap = new HashMap<>();

    public World(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public List<Coordinate> findEntityCoordinates(Class<? extends Entity> clazz) {
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

//    public HashMap<Coordinate, Entity> getWorldMap() {
//        return worldMap;
//    }

    public void addEntity(Coordinate coordinate, Entity entity) {
        worldMap.put(coordinate, entity);
    }

    public void removeEntity(Coordinate coordinate) {
        worldMap.remove(coordinate);
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
