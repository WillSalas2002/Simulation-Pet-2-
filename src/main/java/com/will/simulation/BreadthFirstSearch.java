package com.will.simulation;

import com.will.simulation.model.*;

import java.util.*;

public class BreadthFirstSearch implements PathFinder {
    @Override
    public List<Coordinate> findPath(Creature creature, World world, Class<? extends Entity> targetClass) {
        Coordinate startingCoordinate = creature.getCoordinate();

        // List to store visited cells
        LinkedList<Coordinate> visited = new LinkedList<>();
        visited.add(startingCoordinate);

        // Map to store the parent of each visited coordinate
        HashMap<Coordinate, Coordinate> parentMap = new HashMap<>();
        parentMap.put(startingCoordinate, null);

        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(startingCoordinate);

        while (!queue.isEmpty()) {
            Coordinate currentCoordinate = queue.poll();
            Entity currentEntity = world.findEntityByCoordinate(currentCoordinate);
            if (world.findEntityByCoordinate(currentCoordinate) != null) {
                if (currentEntity.getClass().equals(targetClass)) {
                    List<Coordinate> path = new ArrayList<>();
                    Coordinate traceBack = currentCoordinate;
                    while (traceBack != null) {
                        path.add(traceBack);
                        traceBack = parentMap.get(traceBack);
                    }
                    Collections.reverse(path);
                    path.remove(0);
                    return path;
                }
            }
            List<Coordinate> neighbouringCells = findNeighbouringCells(currentCoordinate, targetClass, world);

            for (Coordinate neighbour : neighbouringCells) {
                if (!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    parentMap.put(neighbour, currentCoordinate);
                    queue.add(neighbour);
                }
            }
        }

        return null;
    }

    private List<Coordinate> findNeighbouringCells(Coordinate startingCoordinate, Class<? extends Entity> targetClass, World world) {

        List<Coordinate> neighbours = new ArrayList<>();

        // resulting static Entity coordinates
        List<Coordinate> staticEntityCoordinates = new ArrayList<>();

        // static Entities coordinates for all
        List<Coordinate> rockCoordinates = world.findEntityCoordinates(Rock.class);
        List<Coordinate> treeCoordinates = world.findEntityCoordinates(Tree.class);

        staticEntityCoordinates.addAll(rockCoordinates);
        staticEntityCoordinates.addAll(treeCoordinates);

        // static Entities coordinates by Creature type
        if (targetClass == Herbivore.class) { // this is Predator
            List<Coordinate> grassCoordinates = world.findEntityCoordinates(Grass.class);
            List<Coordinate> predatorCoordinates = world.findEntityCoordinates(Predator.class);
            staticEntityCoordinates.addAll(grassCoordinates);
            staticEntityCoordinates.addAll(predatorCoordinates);
        } else if (targetClass == Grass.class) { // this is Herbivore
            List<Coordinate> predatorCoordinates = world.findEntityCoordinates(Predator.class);
            List<Coordinate> herbivoreCoordinates = world.findEntityCoordinates(Herbivore.class);
            staticEntityCoordinates.addAll(predatorCoordinates);
            staticEntityCoordinates.addAll(herbivoreCoordinates);
        }

        int[] cellX = new int[]{-1, 0, 1};
        int[] cellY = new int[]{-1, 0, 1};

        // Finding neighbouring Cells
        for (int x = 0; x < cellX.length; x++) {
            for (int y = 0; y < cellY.length; y++) {
                Coordinate neighbouringCellCoordinate = new Coordinate(startingCoordinate.getX() + cellX[x], startingCoordinate.getY() + cellY[y]);

                if (neighbouringCellCoordinate.getX() >= 0 && neighbouringCellCoordinate.getY() >= 0 &&
                        neighbouringCellCoordinate.getX() <= (world.getWidth() - 1) && neighbouringCellCoordinate.getY() <= (world.getHeight() - 1) &&
                        !neighbouringCellCoordinate.equals(startingCoordinate) &&
                        !staticEntityCoordinates.contains(neighbouringCellCoordinate)) {
                    neighbours.add(neighbouringCellCoordinate);
                }
            }
        }
        return neighbours;
    }
}
