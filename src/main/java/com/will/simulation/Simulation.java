package com.will.simulation;

import com.will.simulation.model.Grass;
import com.will.simulation.model.Herbivore;

import java.util.List;

public class Simulation {
    private final World world;
    private int counter;
    private final WorldRenderer worldRenderer;
    private final Action action;

    public Simulation(World world, WorldRenderer worldRenderer, Action action) {
        this.world = world;
        this.worldRenderer = worldRenderer;
        this.action = action;
    }

    public void nextTurn() {
        worldRenderer.render(world);
        action.turnActions();
    }

    /*
    public void run() {
        Thread startThread = new Thread(this::startSimulation);
        Thread pauseThread = new Thread(this::pauseSimulation);

        pauseThread.start();
        startThread.start();
        try {
            pauseThread.join();
            startThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        startSimulation();
    }
    */

    public void startSimulation() {
        List<Coordinate> grassCoordinates;
        List<Coordinate> herbivoreCoordinates;
        do {
            if (counter == 18) {
                int i = 0;
            }
            if (counter == 25) {
                int i = 0;
            }
            grassCoordinates = world.findEntityCoordinates(Grass.class);
            herbivoreCoordinates = world.findEntityCoordinates(Herbivore.class);
            nextTurn();
            counter++;
            try {
                Thread.sleep(1200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        } while (!grassCoordinates.isEmpty() && !herbivoreCoordinates.isEmpty());
        System.out.println("The total number of looping is: " + counter);
    }

    private void pauseSimulation() {
    }
}
