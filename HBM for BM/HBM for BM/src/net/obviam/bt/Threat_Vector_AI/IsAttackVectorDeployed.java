package net.obviam.bt.Threat_Vector_AI;

import net.obviam.bt.Agent;
import net.obviam.bt.World;

public class IsAttackVectorDeployed extends Routine {

    public IsAttackVectorDeployed() {}

    @Override
    public void reset() {
        start();
    }

    @Override
    public void act(Agent agent, World world) {
        // find agent in range
        for (Agent enemy : world.getSocial_World()) {
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
