package net.obviam.bt;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import java.util.TimerTask;


public class Clock{
    Agent agent;
    Agent agent1;
    ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
    public boolean shutdown = false;

    public Clock(Agent agent, Agent agent1) {
        this.agent = agent;
        this.agent1 = agent1;
    }

    public void run() {
        exec.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                // TODO add your code here:
                while(!shutdown){
                    agent.update();
                    agent1.update();
                    System.out.println(agent);
                    System.out.println(agent1);
                }
            }
        }, 0, 1, TimeUnit.SECONDS);
        //Try running the system.
    }
    public void end(){
        //shutdown = true;
        System.exit(0);
    }

}

