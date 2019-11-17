package net.obviam.bt.Agent.AI.Perception_Interface;

import net.obviam.bt.Agent.*;
import net.obviam.bt.Agent.AI.Perception.Perceive;

public class Event_Handler {

    Perceive perception = new Perceive();
    private Agent agent;

    public Event_Handler(Agent agent) {
        this.agent = agent;
    }

    public void seeNothing(){
        perception.perceive(agent, Event.SEE_NOTHING);
    }

    public void seeMail(){
        System.out.println(agent.getActor() + ": Observes mail pop up on desktop window");
        perception.perceive(agent, Event.SEE_MAIL);
    }

    public void seeFlashDrive(){
        System.out.println(agent.getActor() + ": Observes a flash drive in nearby surroundings");
        perception.perceive(agent, Event.SEE_FLASH_DRIVE);
    }

}
