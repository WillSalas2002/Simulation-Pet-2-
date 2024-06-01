package com.will.simulation.action;

import com.will.simulation.Coordinate;
import com.will.simulation.World;
import com.will.simulation.model.Creature;

public class TurnAction extends ActionStrategy {

    public TurnAction(World world) {
        super(world);
    }

    @Override
    public void executeAction() {
        for (Coordinate coordinate : world.findAllCreatureCoordinates()) {
            Creature creature = (Creature) world.findEntityByCoordinate(coordinate);
            creature.makeMove(world);
        }
    }
}
