package com.will.simulation.factory;

import com.will.simulation.model.Entity;
import com.will.simulation.model.Tree;

public class TreeFactory implements EntityFactory {
    @Override
    public Entity createEntity() {
        return new Tree();
    }
}
