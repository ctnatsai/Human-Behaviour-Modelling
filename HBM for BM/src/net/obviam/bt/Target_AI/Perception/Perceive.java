package net.obviam.bt.Target_AI.Perception;

import net.obviam.bt.*;
import net.obviam.bt.Personality.Personality_Composition;
import net.obviam.bt.Target_AI.Perception_Interface.Event;
import net.obviam.bt.Target_AI.Perception_Interface.EventHandler;
import net.obviam.bt.Target_AI.Perception_Interface.Memory;
import net.obviam.bt.Behaviour_Tree.*;
import net.obviam.bt.Clock;

import java.util.concurrent.ScheduledExecutorService;

public class Perceive extends Routine {
    Memory memory = new Memory();
    EventHandler eventHandler;
    Clock clock;

    public Perceive() { }


    @Override
    public void reset() {
        start();
    }

    private boolean p_E1_AND_E2(boolean e1, boolean e2){
        return e1 && e2;
    }

    private boolean applyThreshold(int personalityValue){
        return personalityValue >= 3.5;
    }

    private boolean isTrusting(Personality_Composition personality_composition, int event){
        switch (event){
            case Event.SEE_MAIL:
                return p_E1_AND_E2(
                        applyThreshold(personality_composition.getExtroversion()),
                        applyThreshold(personality_composition.getAgreeableness())
                );
            case Event.SEE_FLASH_DRIVE:
                return p_E1_AND_E2(
                        !(applyThreshold(personality_composition.getExtroversion())),
                        applyThreshold(personality_composition.getConscientiousness())
                );
            default:
                return true;
        }
    }

    @Override
    public void act(Agent agent, World world) {
        if (memory.equals(null)){
            fail();
        }else if (agent.getMemory().size() > 0){
            if(isTrusting(agent.getPersonality_Composition(), agent.getMemory().peek())) {
                succeed();
                System.exit(0);
            }
            else{
                fail();
                System.exit(0);
            }
        }
    }
}
