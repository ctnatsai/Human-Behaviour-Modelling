package net.obviam.bt.Target_AI.Perception_Interface;

import net.obviam.bt.Target_AI.Perception.Perceive;
import net.obviam.bt.World;
import net.obviam.bt.*;

public class EventHandler {

    public enum Event_Type{ SEE_NOTHING, SEE_MAIL, SEE_FLASH_DRIVE }

    private Event_Type event_type;
    private Agent agent;

    public EventHandler(Agent agent) {
        this.agent = agent;
    }

    public void seeNothing(){
        this.agent.updateMemory(Event.SEE_NOTHING);
        this.event_type = Event_Type.SEE_NOTHING;
    }

    public void seeMail(){
        this.agent.updateMemory(Event.SEE_MAIL);
        this.event_type = Event_Type.SEE_MAIL;
    }

    public void seeFlashDrive(){
        this.agent.updateMemory(Event.SEE_FLASH_DRIVE);
        this.event_type = Event_Type.SEE_FLASH_DRIVE;
    }

    public Event_Type getEventType() {
        return event_type;
    }

    public void setEventType(Event_Type event_type) {
        this.event_type = event_type;
    }

    @Override
    public String toString() {
    return  "name= " + this.agent.getActor() +
            ", performingTaskId= " + this.agent.getGoal() +
            ",performing routine=" + this.agent.getRoutine().toString() +
            "event type=" + this.getEventType().toString();
    }
}
