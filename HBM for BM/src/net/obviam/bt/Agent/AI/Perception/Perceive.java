package net.obviam.bt.Agent.AI.Perception;

import net.obviam.bt.Agent.*;
import net.obviam.bt.Agent.AI.Perception_Interface.*;
import net.obviam.bt.Agent.AI.Memory.*;
import net.obviam.bt.Agent.AI.Reason.Reasoner;
import net.obviam.bt.World_Setup.*;

public class Perceive {
    Random_Access_Memory memory = new Random_Access_Memory();
    Reasoner reasoner = new Reasoner();
    Clock clock;
    Event event;

    public Perceive() { }

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
                return false;
        }
    }

    public void perceive(Agent agent, int event) {
            //The reasoner function is called from this method, all things being equal.
          if(isTrusting(agent.getPersonality_Composition(), event)){
              agent.updateMemory(Trust.IS_TRUSTING);
              printConsoleSuccess(agent);
              reasoner.getReasoner(agent, agent.getMemory());
          }
          else {
              agent.updateMemory(Trust.IS_NOT_TRUSTING);
              printConsoleFail(agent);
              reasoner.getReasoner(agent, agent.getMemory());
          }
    }

    private void printConsoleSuccess(Agent agent){
        System.out.println(agent.getActor() +
                ": Perceives a threat from its current observations");
    }

    private void printConsoleFail(Agent agent){
        System.out.println(agent.getActor() +
                ": Perceives no threat from its current observations");
    }

}
