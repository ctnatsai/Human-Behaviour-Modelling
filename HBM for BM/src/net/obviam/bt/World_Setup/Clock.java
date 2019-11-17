package net.obviam.bt.World_Setup;

import net.obviam.bt.Agent.*;

public class Clock{

    public Clock() { }

    public void execute(Agent target_agent, Agent threat_vector){
        for (int i = 0; i < 100; i++) {
            run(target_agent,threat_vector);
        }
    }
    private void run(Agent target_agent, Agent threat_vector){
        target_agent.update();
        threat_vector.update();
    }

}

