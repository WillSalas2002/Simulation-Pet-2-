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

        List<Coordinate> path = new ArrayList<>();
        while (!queue.isEmpty()) {
            Coordinate currentCoordinate = queue.poll();
            Entity currentEntity = world.findEntityByCoordinate(currentCoordinate);
            if (world.findEntityByCoordinate(currentCoordinate) != null) {
                if (currentEntity.getClass().equals(targetClass)) {
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
            List<Coordinate> neighbouringCells = findNeighbouringCell(currentCoordinate, targetClass, world);

            for (Coordinate neighbour : neighbouringCells) {
                if (!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    parentMap.put(neighbour, currentCoordinate);
                    queue.add(neighbour);
                }
            }
        }
        return path;
    }

    private List<Coordinate> findNeighbouringCell(Coordinate startingCoordinate, Class<? extends Entity> targetClass, World world) {
        List<Coordinate> neighbours = new ArrayList<>();

        int[] i = new int[]{0, 1, -1};

        for (int x = 0; x < i.length; x++) {
            for (int y = 0; y < i.length; y++) {

                if (x == 0 && y == 0) continue; // Skip the current cell
                Coordinate offeringCell = new Coordinate(startingCoordinate.getX() + i[x], startingCoordinate.getY() + i[y]);

                if (offeringCell.getX() < 0 || offeringCell.getX() >= world.getWidth() ||
                        offeringCell.getY() < 0 || offeringCell.getY() >= world.getHeight()) continue; // skip if out of bounds;

                if (world.isCellEmpty(offeringCell) || world.findEntityByCoordinate(offeringCell).getClass() == targetClass) {
                    neighbours.add(offeringCell);
                }
            }
        }
        return neighbours;
    }
}
