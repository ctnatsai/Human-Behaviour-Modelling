package net.obviam.bt.Agent.AI.Reason;

import net.obviam.bt.Agent.AI.Memory.Random_Access_Memory;
import net.obviam.bt.Agent.Agent;
import net.obviam.bt.Agent.General_Experiences;

public class Reasoner {

    public Reasoner() { }

    private void elicitsInformation(int general_experience, int trusting, Agent agent){
        //relationship for general experience not yet known...there is need for live data
        if(trusting == 1)
            System.out.println(agent.getActor() + ": Successfully complies to SEA");
        else
            System.out.println(agent.getActor() + ": Does not complies to SEA");
    }

    public void getReasoner(Agent agent, Random_Access_Memory ram){
        int trusting;
        if(ram.size() > 0){
            elicitsInformation(agent.getGeneralExperiences(), ram.peek(), agent);
        }
        else {
            return;
        }
    }
}
