package net.obviam.bt.ai;

import net.obviam.bt.World;
import net.obviam.bt.Agent;

public class IsAttackVectorDeployed extends Routine {

    public IsAttackVectorDeployed() {}

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
            fail();
        }
    }

    private boolean isInRange(Agent agent, Agent enemy) {
        return (Math.abs(agent.getTaskProgress() - enemy.getTaskProgress()) <= agent.getRange());
    }
}
