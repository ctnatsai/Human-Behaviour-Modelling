package net.obviam.bt;

import java.util.ArrayList;
import java.util.List;

public class World {

    final int width;
    final int height;

    private List<Agent> agents = new ArrayList<Agent>();

    public World(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void addDroid(Agent agent) {
        if (isTileWalkable(agent.getX(), agent.getY())) {
            agents.add(agent);
            agent.setBoard(this);
        }
    }

    public boolean isTileWalkable(int x, int y) {
        for (Agent agent : agents) {
            if (agent.getX() == x && agent.getY() == y) {
                return false;
            }
        }
        return true;
    }

    public List<Agent> getAgents() {
        return agents;
    }
}
