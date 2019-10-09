package net.obviam.bt;

import java.util.ArrayList;
import java.util.List;

public class World {

    //Define all the opportunities that come with the world.
    final int physiological_opportunities;
    final int subsistence_opportunities;
    final int aspirational_opportunities;

    private List<Agent> social_world = new ArrayList<Agent>();
    private  final int null_opportunities = 0;

    public World(int physiological_opportunities, int subsistence_opportunities, int aspirational_opportunities) {
        this.physiological_opportunities = physiological_opportunities;//predominantly food
        this.subsistence_opportunities = subsistence_opportunities;//predominantly self defence against attackers
        this.aspirational_opportunities = aspirational_opportunities;//predominantly working effectively
    }

    public int getPhysiological_opportunities() {
        return physiological_opportunities;
    }
    public int getSubsistence_opportunities() { return subsistence_opportunities; }
    public int getAspirational_opportunities() {
        return aspirational_opportunities;
    }

    //Adding agent to the world is no longer depended on the whether or not there are other agents occupying the same
    //positions. This method therefore is supposed to only include the, "agents.add(agent);" statement.
    public void addAgent(Agent agent) {
        social_world.add(agent);
        agent.setWorld(this);
        /*
        if (isTaskDoable(agent.getTaskProgress())) {
            social_world.add(agent);
            agent.setWorld(this);
        }
        */
    }

    //This method has to be changed given that task do-ability is not based on whether or not another agent is occupying
    //the same time. This is where this method and the move to method fail for implementation in this case.
    public boolean isTaskDoable(int task) {
        if(!((task <= null_opportunities) && (task > aspirational_opportunities)))
            return true;
        else
            return false;
        /*
        for (Agent agent : social_world) {
            if (agent.getTaskProgress() == task ) {
                return false;
            }
        }
        return true;
        */
    }

    public List<Agent> getSocial_World() {//returns a list of the other agents in the world
        return social_world;
    }
}
