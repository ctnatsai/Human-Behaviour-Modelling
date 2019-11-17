package net.obviam.bt;


        import net.obviam.bt.Agent.Agent;
        import net.obviam.bt.Agent.Behaviour_Tree.*;
        import net.obviam.bt.Agent.General_Experiences;
        import net.obviam.bt.Agent.Personality_Composition;
        import net.obviam.bt.Personality_Generator.Generate_Personality_Metrics;
        import net.obviam.bt.Personality_Generator.Personality_Quiz;
        import net.obviam.bt.World_Setup.*;
        import javax.swing.*;

public class Main {
    private JPanel panel1;
    private JPanel mainPanel;
    private JPanel canvas;

    public static void main(String[] args) {
//        JFrame frame = new JFrame("Main");
//        frame.setPreferredSize(new Dimension(800, 600));
//        frame.setResizable(false);
//        frame.setContentPane(new Main().mainPanel);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.pack();
//        frame.setVisible(true);

        // Setup world and initialise time
        World world = new World(5,10, 20);
        //Calculate personality
        Personality_Quiz agent_answers1 = new Personality_Quiz();
        agent_answers1.get_answers();

        Generate_Personality_Metrics personality_metrics = new Generate_Personality_Metrics(agent_answers1);
        Personality_Composition personality_composition = new Personality_Composition(
                personality_metrics.is_extrovert_metrics(),
                personality_metrics.is_agreeable_metrics(),
                personality_metrics.is_neurotic_metrics(),
                personality_metrics.is_open_metrics(),
                personality_metrics.is_conscientious_metrics()
        );

        //Initialise agent with personality and initial goal.
        Agent target_agent1 = new Agent("Employee", 20, personality_composition, new General_Experiences(1));
        //Print out personality composition of the agent
        System.out.println(target_agent1.getActor() + ": Big 5 Personality Composition\n" + target_agent1.getPersonality_Composition().toString());

        Agent threat_vector = new Agent("Social" + " Engineer", 20, personality_composition, new General_Experiences(0));

        //Start the clock.
        Clock clock = new Clock();
        world.addAgent(target_agent1);
        world.addAgent(threat_vector);

        Routine goal_work = Routines.repeat(
                Routines.sequence(
                        Routines.drinkCoffee(world),
                        Routines.selector(
                                Routines.sensor(),
                                Routines.work(world)
                        )
                ), 1
        );
        target_agent1.setRoutine(goal_work);

        Routine goal_deploy_attack_vector = Routines.repeat(
                Routines.sequence(
                        Routines.work(world),
                        Routines.deployAttackVector(1)

                ), 1
        );
        threat_vector.setRoutine(goal_deploy_attack_vector);

        //Beginning of workplace simulation run
        System.out.println("Start of workplace simulation run-->");
        clock.execute(target_agent1, threat_vector);
        //End of workplace simulation run
        System.out.println("-->End of workplace simulation run");

    }
}
