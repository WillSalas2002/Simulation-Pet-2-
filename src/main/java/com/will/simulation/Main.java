package com.will.simulation;

/* TODO:
    1. Learn Multithreading, simulating running of main program and waiting another thread for an input
    2. Populating map with the exact proportions of entities
    3. Move the logic for eating and moving in (herbivore, predator) classes into creature, remove duplicating
    4. Adding options (start, pause, resume, exit)
    5. Deploy the program and send it to reviewing
 */

public class Main {
    public static void main(String[] args) {
        Simulation simulation = new Simulation(new World(20, 16));
        simulation.startSimulation();
    }
}
