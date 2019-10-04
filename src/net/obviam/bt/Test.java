package net.obviam.bt;

import net.obviam.bt.ai.Repeat;
import net.obviam.bt.ai.Routine;
import net.obviam.bt.ai.Routines;
import net.obviam.bt.ai.Work;

public class Test {

    public static void main(String[] args) {
        // Setup
        World world = new World(10);

        Agent agent = new Agent("MyAgent", 5, 5, 10, 1);
        world.addAgent(agent);

        Routine scenarioComposition = Routines.repeatInfinite(
                Routines.selector(
                        Routines.sequence(
                                Routines.IsAttackVectorDeployed(),
                                Routines.work(world)
                        ),
                        Routines.work(world)
                )
        );

        Routine routine = new Repeat((new Work(world)));
        agent.setRoutine(scenarioComposition);
        System.out.println(agent);

        for (int i = 0; i < 10; i++) {
            agent.update();
            System.out.println(agent);
        }
    }
}
