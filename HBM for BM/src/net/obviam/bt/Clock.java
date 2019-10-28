package net.obviam.bt;

import java.util.TimerTask;

import net.obviam.bt.Target_AI.*;

public class Clock{
    //use stopwatch for the clock instead
    Agent agent;
    Agent agent1;

    public Clock(Agent agent, Agent agent1) {
        this.agent = agent;
        this.agent1 = agent1;
    }

    public void run() {
        //Try running the system.
        agent.update();
        agent1.update();
        System.out.println(agent);
        System.out.println(agent1);

    }

}

