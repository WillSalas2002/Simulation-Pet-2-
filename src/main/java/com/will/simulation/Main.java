package com.will.simulation;

/* TODO:
    1. Learn Multithreading, simulating running of main program and waiting another thread for an input
    2. Adding options (start, pause, resume, exit)
    3. Deploy the program and send it to reviewing
 */

public class Main {
    public static void main(String[] args) {

        World world = new World(12, 12);
        Action action = new Action(world);
        action.initActions();
        WorldRenderer worldRenderer = new WorldRenderer();
        Simulation simulation = new Simulation(world, worldRenderer, action);
        simulation.startSimulation();
    }
}
