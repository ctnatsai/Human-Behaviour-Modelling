package net.obviam.bt;

import net.obviam.bt.Agent.*;
import net.obviam.bt.Agent.Behaviour_Tree.*;
import net.obviam.bt.Personality_Generator.*;
import net.obviam.bt.World_Setup.*;

import java.util.Random;

public class Test {

    public static void main(String[] args) {
        // Setup world and initialise time
        World world = new World(2,10, 20);
        //Calculate personality
        Personality_Quiz agent_answers = new Personality_Quiz();
        agent_answers.get_answers();

        Generate_Personality_Metrics personality_metrics = new Generate_Personality_Metrics(agent_answers);
        Personality_Composition personality_composition = new Personality_Composition(
                personality_metrics.is_extrovert_metrics(),
                personality_metrics.is_agreeable_metrics(),
                personality_metrics.is_neurotic_metrics(),
                personality_metrics.is_open_metrics(),
                personality_metrics.is_conscientious_metrics()
        );

        //Initialise agent with personality and initial goal.
        Agent target_agent = new Agent("Employee", 20, personality_composition, new General_Experiences(1));
        //Print out personality composition of the agent
        System.out.println(target_agent.getActor() + ": Big 5 Personality Composition\n" + target_agent.getPersonality_Composition().toString());

        Agent threat_vector = new Agent("Social" + " Engineer", 20, personality_composition, new General_Experiences(0));

        //Start the clock.
        Clock clock = new Clock();
        world.addAgent(target_agent);
        world.addAgent(threat_vector);

        Routine goal_work = Routines.repeat(
                Routines.sequence(
                        Routines.drinkCoffee(world),
                        Routines.selector(
                                Routines.sensor(),
                                Routines.work(world)
                        )
                ), 3
        );
        target_agent.setRoutine(goal_work);

        Routine goal_deploy_attack_vector = Routines.repeat(
                Routines.sequence(
                        Routines.work(world),
                        Routines.deployAttackVector(0),
                        Routines.deployAttackVector(1),
                        Routines.deployAttackVector(2),
                        Routines.deployAttackVector(0)
                ), 3
        );
        threat_vector.setRoutine(goal_deploy_attack_vector);

        //Beginning of workplace simulation run
        System.out.println("Start of workplace simulation run-->");
        clock.execute(target_agent, threat_vector);
        //End of workplace simulation run
        System.out.println("-->End of workplace simulation run");
    }
}
