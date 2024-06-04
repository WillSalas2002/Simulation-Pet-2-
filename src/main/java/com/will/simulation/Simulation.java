package com.will.simulation;

import com.will.simulation.action.ActionStrategy;
import com.will.simulation.action.EntitySpawnAction;
import com.will.simulation.action.InitAction;
import com.will.simulation.action.TurnAction;
import com.will.simulation.factory.GrassFactory;
import com.will.simulation.model.Grass;
import com.will.simulation.model.Herbivore;

public class Simulation {
    private final World world;
    private int counter;
    private final WorldRenderer worldRenderer;

    private final ActionStrategy initAction;
    private final ActionStrategy turnAction;
    private final EntitySpawnAction grassSpawnAction;
    private final int MINIMUM_GRASS_QUANTITY = 3;
    public Simulation(World world) {
        this.world = world;
        this.worldRenderer = new WorldRenderer();
        this.initAction = new InitAction(world);
        this.turnAction = new TurnAction(world);
        this.grassSpawnAction = new EntitySpawnAction(world, new GrassFactory(), 3);

    }

    public void nextTurn() {
        worldRenderer.render(world);
        turnAction.executeAction();
    }

    public void start() {
        initAction.executeAction();
        do {
            nextTurn();
            pauseBetweenLoops(1200);

            if (world.getEntityQuantityByType(Grass.class) < MINIMUM_GRASS_QUANTITY) {
                incrementGrass();
            }
            counter++;
        } while (!isGameFinished());
        System.out.println("The total number of looping is: " + counter);
    }

    private boolean isGameFinished() {
        return world.getEntityQuantityByType(Herbivore.class) == 0;
    }

    private void incrementGrass() {
            grassSpawnAction.executeAction();
    }

    private void pauseBetweenLoops(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
