package com.will.simulation;

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

    public void startSimulation() {
        do {
            nextTurn();
            try {
                Thread.sleep(1200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            counter++;
        } while (!world.isGameFinished());
        System.out.println("The total number of looping is: " + counter);
    }

    private void pauseSimulation() {
    }
}
