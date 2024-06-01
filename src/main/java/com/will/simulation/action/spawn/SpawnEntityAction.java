package com.will.simulation.action.spawn;

import com.will.simulation.Coordinate;
import com.will.simulation.World;
import com.will.simulation.action.ActionStrategy;
import com.will.simulation.model.Entity;

public class SpawnEntityAction<T extends Entity> extends ActionStrategy {
    private final T entityType;
    public int rate;

    public SpawnEntityAction(World world, T entityType) {
        super(world);
        this.entityType = entityType;
    }

    @Override
    public void executeAction() {
        Coordinate randomCoordinate = world.generateRandomEmptyCoordinate();
        Entity entity = world.getNewEntityByType(entityType.clone().getClass());
        world.placeEntity(randomCoordinate, entity);
    }
}
