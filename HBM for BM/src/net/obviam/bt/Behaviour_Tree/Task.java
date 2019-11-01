package net.obviam.bt.Behaviour_Tree;

import net.obviam.bt.World;
import net.obviam.bt.Agent;

public class Task extends Routine {

    final protected int task;

    public Task(int task) {
        super();
        this.task = task;
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
            if (!isTaskComplete(agent)) {
                modifyTask(agent);
            }
        }
    }

    private void modifyTask(Agent agent) {
        if (task != agent.getTaskProgress()) {
            if (task > agent.getTaskProgress()) {
                agent.setTaskProgress(agent.getTaskProgress() + 1);
            } else {
                agent.setTaskProgress(agent.getTaskProgress() - 1);
            }
        }
        if (isTaskComplete(agent)) {
            succeed();
        }
    }

    private boolean isTaskComplete(Agent agent) {
        return task == agent.getTaskProgress();
    }
}
