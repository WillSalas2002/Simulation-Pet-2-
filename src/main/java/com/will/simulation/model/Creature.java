package com.will.simulation.model;

import com.will.simulation.PathFinder;
import com.will.simulation.BreadthFirstSearch;
import com.will.simulation.World;
import lombok.Getter;
import lombok.Setter;

public abstract class Creature extends Entity {
    protected PathFinder pathFinder = new BreadthFirstSearch();
    protected int speed;
    @Setter @Getter
    protected int life;

    public Creature() {
    }

    public Creature(Creature target) {
        if (target != null) {
            this.coordinate = target.coordinate;
            this.life = target.life;
            this.speed = target.speed;
            this.pathFinder = target.pathFinder;
            this.sign = target.sign;
        }
    }

    public abstract void makeMove(World world);
}
