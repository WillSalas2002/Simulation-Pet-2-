package com.will.simulation.factory;

import com.will.simulation.model.Entity;
import com.will.simulation.model.Predator;

public class PredatorFactory implements EntityFactory {
    @Override
    public Entity createEntity() {
        return new Predator();
    }
}
