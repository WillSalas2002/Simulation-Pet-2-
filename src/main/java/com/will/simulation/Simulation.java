package com.will.simulation;

import com.will.simulation.action.ActionStrategy;
import com.will.simulation.action.spawn.GrassSpawnAction;
import com.will.simulation.action.InitAction;
import com.will.simulation.action.TurnAction;
import com.will.simulation.model.Grass;

public class Simulation {
    private final World world;
    private int counter;
    private final WorldRenderer worldRenderer;

    private final ActionStrategy initAction;
    private final ActionStrategy turnAction;
    private final GrassSpawnAction grassSpawnAction;
    public Simulation(World world) {
        this.world = world;
        this.worldRenderer = new WorldRenderer();
        this.initAction = new InitAction(world);
        this.turnAction = new TurnAction(world);
        this.grassSpawnAction = new GrassSpawnAction(world);

    }

    public void nextTurn() {
        worldRenderer.render(world);
        turnAction.executeAction();
    }

    public void startSimulation() {
        initAction.executeAction();
        do {
            nextTurn();
            pauseBetweenLoops(1200);

            if (world.getEntityQuantityByType(Grass.class) < 3) {
                incrementGrass();
            }
            counter++;
        } while (!world.isGameFinished());
        System.out.println("The total number of looping is: " + counter);
    }

    private void incrementGrass() {
        for (int i = 0; i < 5; i++) {
            grassSpawnAction.executeAction();
        }
    }

    private void pauseBetweenLoops(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
