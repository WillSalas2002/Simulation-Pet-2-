package com.will.simulation.factory;

import com.will.simulation.model.Entity;
import com.will.simulation.model.Grass;

public class GrassFactory implements EntityFactory {
    @Override
    public Entity createEntity() {
        return new Grass();
    }
}
