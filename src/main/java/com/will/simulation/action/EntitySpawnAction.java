package com.will.simulation.action;

import com.will.simulation.Coordinate;
import com.will.simulation.World;
import com.will.simulation.factory.EntityFactory;
import com.will.simulation.model.Entity;

import java.util.Random;

public class EntitySpawnAction extends ActionStrategy {
    private final EntityFactory entityFactory;
    private int rate;

    public EntitySpawnAction(World world, EntityFactory entityFactory, int rate) {
        super(world);
        this.entityFactory = entityFactory;
        this.rate = rate;
    }

    @Override
    public void executeAction() {
        for (int i = 0; i < rate; i++) {
            Coordinate randomCoordinate = getRandomEmptyCoordinate();
            Entity entity = entityFactory.createEntity();
            world.placeEntity(randomCoordinate, entity);
        }
    }

    private Coordinate getRandomEmptyCoordinate() {
        final Random random = new Random();
        Coordinate coordinate;
        do {
            int y = random.nextInt(world.getHeight());
            int x = random.nextInt(world.getWidth());
            coordinate = new Coordinate(x, y);
        } while (!world.isCellEmpty(coordinate));

        return coordinate;
    }
}
