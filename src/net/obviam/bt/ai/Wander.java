package net.obviam.bt.ai;

import net.obviam.bt.World;
import net.obviam.bt.Agent;

import java.util.Random;

public class Wander extends Routine {

    private static Random random = new Random();
    private final World world;
    private MoveTo moveTo;

    @Override
    public void start() {
        super.start();
        this.moveTo.start();
    }

    public void reset() {
        this.moveTo = new MoveTo(random.nextInt(world.getWidth()), random.nextInt(world.getHeight()));
    }

    public Wander(World world) {
        super();
        this.world = world;
        this.moveTo = new MoveTo(random.nextInt(world.getWidth()), random.nextInt(world.getHeight()));
    }

    @Override
    public void act(Agent agent, World world) {
        if (!moveTo.isRunning()) {
            return;
        }
        this.moveTo.act(agent, world);
        if (this.moveTo.isSuccess()) {
            succeed();
        } else if (this.moveTo.isFailure()) {
            fail();
        }
    }
}
