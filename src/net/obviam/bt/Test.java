package net.obviam.bt;

import net.obviam.bt.ai.Repeat;
import net.obviam.bt.ai.Routine;
import net.obviam.bt.ai.Wander;

public class Test {

    public static void main(String[] args) {
        // Setup
        World world = new World(10, 10);

        Agent agent = new Agent("MyAgent", 5, 5, 10, 1, 2);
        world.addDroid(agent);

        Routine routine = new Repeat((new Wander(world)));
        agent.setRoutine(routine);
        System.out.println(agent);

        for (int i = 0; i < 10; i++) {
            agent.update();
            System.out.println(agent);
        }
    }
}
