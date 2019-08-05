package net.obviam.bt.ai;

import net.obviam.bt.World;
import net.obviam.bt.Agent;

public class IsAgentInRange extends Routine {

    public IsAgentInRange() {}

    @Override
    public void reset() {
        start();
    }

    @Override
    public void act(Agent agent, World world) {
        // find agent in range
        for (Agent enemy : world.getAgents()) {
            if (!agent.getName().equals(enemy)) {
                if (isInRange(agent, enemy)) {
                    succeed();
                    break;
                }
            }
        }
        fail();
    }

    private boolean isInRange(Agent agent, Agent enemy) {
        return (Math.abs(agent.getX() - enemy.getX()) <= agent.getRange()
                && Math.abs(agent.getY() - enemy.getY()) <= agent.getRange());
    }
}
