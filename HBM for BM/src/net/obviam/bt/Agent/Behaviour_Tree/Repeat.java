package net.obviam.bt.Agent.Behaviour_Tree;

import net.obviam.bt.Agent.*;
import net.obviam.bt.World_Setup.*;

public class Repeat extends Routine {

    private final Routine routine;
    private int times;
    private int originalTimes;

    public Repeat(Routine routine) {
        super();
        this.routine = routine;
        this.times = -1; // infinite
        this.originalTimes = times;
    }

    public Repeat(Routine routine, int times) {
        super();
        if (times < 1) {
            throw new RuntimeException("Can't repeat negative times.");
        }
        this.routine = routine;
        this.times = times;
        this.originalTimes = times;
    }

    @Override
    public void start() {
        super.start();
        this.routine.start();
    }

    public void reset() {
        // reset counters
        this.times = originalTimes;
    }

    @Override
    public void act(Agent agent, World world) {
        if(routine.isFailure()) {
            fail();
        } else if (routine.isSuccess()) {
            if (times == 0) {
                succeed();
                return;
            }
            if (times != 0) {
                times--;
                routine.reset();
                routine.start();
            }
        }
        if (routine.isRunning()) {
            routine.act(agent, world);
        }
    }

}
