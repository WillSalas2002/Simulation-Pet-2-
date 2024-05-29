package com.will.simulation.model;

import com.will.simulation.PathFinder;
import com.will.simulation.BreadthFirstSearch;
import com.will.simulation.World;

public abstract class Creature extends Entity {
    protected PathFinder pathFinder = new BreadthFirstSearch();
    protected int speed = 1;
    protected int life = 100;

    public Creature() {
    }

    public Creature(Creature target) {
        super(target);
        if (target != null) {
            this.life = target.life;
            this.speed = target.speed;
            this.pathFinder = target.pathFinder;
        }
    }

    public abstract void makeMove(World world);
}
