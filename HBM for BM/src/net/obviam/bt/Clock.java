package net.obviam.bt;

import java.util.Timer;
import java.util.TimerTask;

public class Clock extends TimerTask {

    Agent agent;
    Timer act_lifetime;

    private static int lifetime = 50; //Ticks

    public Clock(Timer act_duration, Agent agent) {
        this.agent = agent;
        this.act_lifetime = act_duration;
    }

    @Override
    public void run() {
        //Try running the system.
        try{
            if (lifetime >= 0){
                agent.update();
                System.out.println(agent);
                lifetime--;
            }else {
                act_lifetime.cancel();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
