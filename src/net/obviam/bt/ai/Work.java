package net.obviam.bt.ai;

import net.obviam.bt.World;
import net.obviam.bt.Agent;

import java.util.Random;

public class Work extends Routine {

    private static Random random = new Random();
    private final World world;
    private Task task;

    @Override
    public void start() {
        super.start();
        this.task.start();
    }

    public void reset() {
        this.task = new Task(random.nextInt(world.getTasks()));
    }

    public Work(World world) {
        super();
        this.world = world;
        this.task = new Task(random.nextInt(world.getTasks()));
    }

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
