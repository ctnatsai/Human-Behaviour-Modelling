package net.obviam.bt.Agent.AI.Behaviours.Behaviours_Target;

import net.obviam.bt.Agent.*;
import net.obviam.bt.Agent.Behaviour_Tree.*;
import net.obviam.bt.World_Setup.*;

import java.util.Random;

public class DrinkCoffee extends Routine {
    private Agent agent;
    private World world;
    private Task task;

    public DrinkCoffee(World world) {
        this.world = world;
        this.task = new Task(new Random().nextInt((world.getPhysiological_opportunities())), "Drinking Coffee");
    }

    @Override
    public void start() {
        super.start();
        this.task.start();
    }

    @Override
    public void reset() { this.task = new Task(new Random().nextInt(world.getPhysiological_opportunities()), "Drinking Coffee");  }

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
