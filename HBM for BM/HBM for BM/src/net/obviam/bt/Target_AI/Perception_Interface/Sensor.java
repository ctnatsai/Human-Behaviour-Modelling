package net.obviam.bt.Target_AI.Perception_Interface;

import net.obviam.bt.Agent;
import net.obviam.bt.Target_AI.Perception_Interface.*;
import net.obviam.bt.Target_AI.Routine;
import net.obviam.bt.World;

public class Sensor extends Routine {
    EventHandler event_handler = new EventHandler();

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

    private void updateEventHandler(World world){
        if (isNothing(world)) {
            event_handler.seeNothing();
        }else if(isMail(world)){
            event_handler.seeMail();
        }else if(isNothing(world)){
            event_handler.seeFlashDrive();
        }
    }

    @Override
    public void reset() {
        start();
    }

    @Override
    public void act(Agent agent, World world) {
        if(sensePhysicalWorld(world)){
            updateEventHandler(world);
            succeed();
        }else if(!sensePhysicalWorld(world)){
            updateEventHandler(world);
            fail();
        }
    }
}
