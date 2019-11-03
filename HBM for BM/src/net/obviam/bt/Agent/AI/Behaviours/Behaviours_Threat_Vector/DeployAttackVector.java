package net.obviam.bt.Agent.AI.Behaviours.Behaviours_Threat_Vector;

import net.obviam.bt.Agent.Agent;
import net.obviam.bt.Agent.Behaviour_Tree.Routine;
import net.obviam.bt.World_Setup.World;

public class DeployAttackVector extends Routine {
    int attack_vector;

    public DeployAttackVector(int attack_vector) {
        this.attack_vector = attack_vector;
    }

    private void deployAttackVector(World world){
        world.addPhysicalOpportunities(this.attack_vector);
    }

    @Override
    public void reset() {
        start();
    }

    @Override
    public void act(Agent agent, World world) {
        deployAttackVector(world);
        succeed();
    }
}
