package net.obviam.bt;

import net.obviam.bt.Target_AI.*;
import net.obviam.bt.Personality.*;

import java.util.Random;
import java.util.Timer;

public class Test {

    public static void main(String[] args) {
        // Setup world and initialise time
        World world = new World(2,10, 20);
        //Calculate personality
        Personality_Quiz agent_answers = new Personality_Quiz();
        agent_answers.get_answers();

        Personality_Metrics personality_metrics = new Personality_Metrics(agent_answers);
        Personality_Composition personality_composition = new Personality_Composition(
                personality_metrics.is_extrovert_metrics(),
                personality_metrics.is_agreeable_metrics(),
                personality_metrics.is_neurotic_metrics(),
                personality_metrics.is_open_metrics(),
                personality_metrics.is_conscientious_metrics()
        );

        //Initialise agent with personality and initial goal.
        Agent target_agent = new Agent("employee", 20, personality_composition);




        Agent threat_vector = new Agent("social_engineer", 20, personality_composition);

        //Start the clock.
        Clock clock = new Clock(target_agent, threat_vector);
        world.addAgent(target_agent);
        world.addAgent(threat_vector);

        Routine goal_work = Routines.repeatInfinite(
                Routines.sequence(
                        Routines.work(world),
                        Routines.sensor(),
                        Routines.selector(
                                Routines.perceive(),
                                Routines.drinkCoffee(world)

                        )
                )
        );
        target_agent.setRoutine(goal_work);

        Routine goal_deploy_attack_vector = Routines.repeatInfinite(
                Routines.sequence(
                        Routines.work(world),
                        Routines.deployAttackVector(1)
                )
        );
        threat_vector.setRoutine(goal_deploy_attack_vector);

        for (int i = 0; i < 100; i++) {
            clock.run();
        }
    }
}
