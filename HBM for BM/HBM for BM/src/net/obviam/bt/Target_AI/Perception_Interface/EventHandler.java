package net.obviam.bt.Target_AI.Perception_Interface;

import net.obviam.bt.Target_AI.PerceptionInterface.Memory;
import net.obviam.bt.World;

public class EventHandler {
    Memory memory = new Memory();

    public enum Event_Type{ SEE_NOTHING, SEE_MAIL, SEE_FLASH_DRIVE }

    private Event_Type event_type;

    public EventHandler() {}

    public void seeNothing(){
        memory.push(Event.SEE_NOTHING);
        this.event_type = Event_Type.SEE_NOTHING;
    }

    public void seeMail(){
        memory.push(Event.SEE_MAIL);
        this.event_type = Event_Type.SEE_MAIL;
    }

    public void seeFlashDrive(){
        memory.push(Event.SEE_FLASH_DRIVE);
        this.event_type = Event_Type.SEE_FLASH_DRIVE;
    }
    //TO DO
    //ADD CONSOLE PRINTER FUNCTION
}
