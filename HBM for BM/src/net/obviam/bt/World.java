package net.obviam.bt;

import java.util.ArrayList;
import java.util.List;

public class World {

    final int tasks;

    private List<Agent> agents = new ArrayList<Agent>();

    public World(int tasks) {
        this.tasks = tasks;
    }

    public int getTasks() {
        return tasks;
    }

    public void addAgent(Agent agent) {
        if (isTaskDoable(agent.getTaskProgress())) {
            agents.add(agent);
            agent.setBoard(this);
        }
    }

    public boolean isTaskDoable(int task) {
        for (Agent agent : agents) {
            if (agent.getTaskProgress() == task ) {
                return false;
            }
        }
        return true;
    }

    public List<Agent> getAgents() {
        return agents;
    }
}
