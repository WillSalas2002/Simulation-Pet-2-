package com.will.simulation.factory;

import com.will.simulation.model.Entity;
import com.will.simulation.model.Rock;

public class RockFactory implements EntityFactory {
    @Override
    public Entity createEntity() {
        return new Rock();
    }
}
