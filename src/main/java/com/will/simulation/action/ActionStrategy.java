package com.will.simulation.action;

import com.will.simulation.World;

public abstract class ActionStrategy {
    protected World world;

    public ActionStrategy(World world) {
        this.world = world;
    }

    public abstract void executeAction();
}
