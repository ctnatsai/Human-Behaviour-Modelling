package net.obviam.bt;

import net.obviam.bt.Target_AI.Repeat;
import net.obviam.bt.Target_AI.Routine;
import net.obviam.bt.Target_AI.Routines;
import net.obviam.bt.Target_AI.Work;

import java.util.Timer;

public class Test {

    public static void main(String[] args) {
        // Setup

        World world = new World(20,40, 60);
        Timer act_duration = new Timer();
        Agent agent = new Agent("MyAgent", 5, 5, 10, 1 );

        Clock clock = new Clock(act_duration, agent);
        world.addAgent(agent);

        Routine routine = new Repeat((new Work(world)));
        agent.setRoutine(routine);

        act_duration.scheduleAtFixedRate(clock, 0, 10);
        clock.run();



        /*Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            private int i = 0;
            @Override
            public void run() {
                if (i <= 30){
                    agent.update();
                    System.out.println(agent);
                    i++;
                }else {
                    timer.cancel();
                }
            }
        };
        timer.scheduleAtFixedRate(timerTask, 0, 1);*/


/*        for (int i = 0; i < 10; i++) {
            agent.update();
            System.out.println(agent);
        } */

        //---------------------------END------------------------------------------------------------------------------//


        //------------------------------------------------------------------------------------------------------------//
        //---------------------------WORKING PROGRESS CODE------------------------------------------------------------//
        //------------------------------------------------------------------------------------------------------------//


        /* Routine scenarioComposition = Routines.repeatInfinite(
                Routines.sequence( //Information Disclosure
                        Routines.sequence(Routines.developRelationship( //Develop Relationship
                                Routines.sequence(Routine.establishCommunication()),
                                Routines.sequence(Routine.buildRapport())
                        )),
                        Routines.sequence(Routines.exploitRelationship( //Exploit Relationship
                                Routines.sequence(Routine.primeTarget()),
                                Routines.selector(
                                        Routine.agentDisclosesCredentials(),
                                        Routine.agentDoesNotDiscloseCredentials()
                                ))
                        ))
        );
        */
    }
}
