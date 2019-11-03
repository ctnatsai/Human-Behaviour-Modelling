package net.obviam.bt.Agent.AI.Perception_Interface;

import net.obviam.bt.Agent.*;
import net.obviam.bt.Agent.Behaviour_Tree.*;
import net.obviam.bt.Agent.AI.Perception.Perceive;
import net.obviam.bt.World_Setup.*;


public class Sensor extends Routine {
    Perceive perceive = new Perceive();

    public Sensor() {}

    private boolean sensePhysicalWorld(World world){
        return (!world.getPhysical_world().isEmpty());
    }

    private boolean isNothing(World world){
        return world.getPhysical_world().isEmpty();
    }

    private boolean isMail(World world){
        return world.getPhysical_world().contains(Event.SEE_MAIL);
    }

    private boolean isFlashDrive(World world){
        return world.getPhysical_world().contains(Event.SEE_FLASH_DRIVE);
    }

    private void updateEventHandler(World world, Event_Handler event_handler){
        if (isNothing(world)) {
            event_handler.seeNothing();
        }else if(isMail(world)){
            event_handler.seeMail();
        }else if(isFlashDrive(world)){
            event_handler.seeFlashDrive();
        }
    }

    @Override
    public void reset() {
        start();
    }

    @Override
    public void act(Agent agent, World world) {
        Event_Handler event_handler = new Event_Handler(agent);
        if(sensePhysicalWorld(world)){
            updateEventHandler(world, event_handler);
            succeed();
        }else if(!sensePhysicalWorld(world)){
            updateEventHandler(world, event_handler);
            fail();
        }
    }
}
