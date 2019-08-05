package net.obviam.bt.ai;

import net.obviam.bt.World;
import net.obviam.bt.Agent;

public class MoveTo extends Routine {

    final protected int destX;
    final protected int destY;

    public MoveTo(int destX, int destY) {
        super();
        this.destX = destX;
        this.destY = destY;
    }

    public void reset() {
        start();
    }

    @Override
    public void act(Agent agent, World board) {
        if (isRunning()) {
            if (!agent.isAlive()) {
                fail();
                return;
            }
            if (!isDroidAtDestination(agent)) {
                moveDroid(agent);
            }
        }
    }

    private void moveDroid(Agent agent) {
        if (destY != agent.getY()) {
            if (destY > agent.getY()) {
                agent.setY(agent.getY() + 1);
            } else {
                agent.setY(agent.getY() - 1);
            }
        }
        if (destX != agent.getX()) {
            if (destX > agent.getX()) {
                agent.setX(agent.getX() + 1);
            } else {
                agent.setX(agent.getX() - 1);
            }
        }
        if (isDroidAtDestination(agent)) {
            succeed();
        }
    }

    private boolean isDroidAtDestination(Agent agent) {
        return destX == agent.getX() && destY == agent.getY();
    }
}
