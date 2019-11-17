package net.obviam.bt.Agent.AI.Behaviours.Behaviours_Target;

import net.obviam.bt.Agent.*;
import net.obviam.bt.Agent.Behaviour_Tree.*;
import net.obviam.bt.World_Setup.*;

import java.lang.reflect.AnnotatedArrayType;
import java.util.Random;

public class Work extends Routine {

    private static Random random = new Random();
    private final World world;
    private Task task;
    private Agent agent;

    @Override
    public void start() {
        super.start();
        this.task.start();
    }

    public void reset() {
        this.task = new Task(new Random().nextInt(world.getAspirational_opportunities()), " Working");
    }

    public Work(World world) {
        super();
        this.world = world;
        this.task = new Task(new Random().nextInt(world.getAspirational_opportunities()), "Working");
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
