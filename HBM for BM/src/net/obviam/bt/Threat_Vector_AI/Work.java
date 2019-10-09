package net.obviam.bt.Threat_Vector_AI;

import net.obviam.bt.Agent;
import net.obviam.bt.World;

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
        this.task = new Task(random.nextInt(world.getPhysiological_opportunities()));
    }

    public Work(World world) {
        super();
        this.world = world;
        this.task = new Task(random.nextInt(world.getPhysiological_opportunities()));
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
