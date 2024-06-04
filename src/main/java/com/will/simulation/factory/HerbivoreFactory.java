package com.will.simulation.factory;

import com.will.simulation.model.Entity;
import com.will.simulation.model.Herbivore;

public class HerbivoreFactory implements EntityFactory {
    @Override
    public Entity createEntity() {
        return new Herbivore();
    }
}
