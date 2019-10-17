package net.obviam.bt.Target_AI;

import net.obviam.bt.Agent;
import net.obviam.bt.World;

import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;

public class DrinkCoffee extends Routine {
    private World world;
    private Task task;

    public DrinkCoffee(World world) {
        this.world = world;
        this.task = new Task(new Random().nextInt((world.getPhysiological_opportunities())));
    }

    @Override
    public void start() {
        super.start();
        this.task.start();
    }

    @Override
    public void reset() { this.task = new Task(new Random().nextInt(world.getPhysiological_opportunities()));  }

    @Override
    public void act(Agent agent, World world) {
        if (!task.isRunning()) {
            return;
        }
        this.task.act(agent, world);
        if (this.task.isSuccess()) {
            succeed();
        } else if (this.task.isFailure()) {
            fail();
        }
    }
}
