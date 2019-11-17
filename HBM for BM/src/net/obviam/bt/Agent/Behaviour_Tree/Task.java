package net.obviam.bt.Agent.Behaviour_Tree;

import net.obviam.bt.Agent.*;
import net.obviam.bt.World_Setup.*;

public class Task extends Routine {

    private boolean isStarted;
    final protected int taskId;
    String task;


    private Agent agent;

    public Task(int taskId, String task) {
        super();
        this.taskId = taskId;
        this.task = task;
    }

    public void reset() {
        start();
        isStarted = true;
    }

    @Override
    public void act(Agent agent, World board) {

        printConsoleTask(agent);
        if (isRunning()) {
            if (!agent.isAlive()) {
                fail();
                printConsoleFailed(agent);
                return;
            }
            if (!isTaskComplete(agent)) {
                modifyTask(agent);
            }
        }
    }

    private void modifyTask(Agent agent) {
        if (taskId != agent.getTaskProgress()) {
            if (taskId > agent.getTaskProgress()) {
                agent.setTaskProgress(agent.getTaskProgress() + 1);
            } else {
                agent.setTaskProgress(agent.getTaskProgress() - 1);
            }
        }
        if (isTaskComplete(agent)) {
            succeed();
            printConsoleSuccess(agent);
        }
    }

    private boolean isTaskComplete(Agent agent) {
        return taskId == agent.getTaskProgress();
    }

    private void printConsoleTask(Agent agent){
        switch (task){
            case "Drinking Coffee":
                System.out.println(agent.getActor() + ": Drinks coffee");
            case "Working":
                System.out.println(agent.getActor() + ": Is working");;
            default: return;
        }
    }

    private void printConsoleSuccess(Agent agent){
        switch (task){
            case "Drinking Coffee":
                System.out.println(agent.getActor() + ": Successfully finished drinking coffee");
            case "Working":
                System.out.println(agent.getActor() + ": Successfully finished assigned work");;
            default: return;
        }
    }

    private void printConsoleFailed(Agent agent){
        switch (task){
            case "Drinking Coffee":
                System.out.println(agent.getActor() + ":Failed to finish drinking coffee");
            case "Working":
                System.out.println(agent.getActor() + ":Failed to finish work");;
            default: return;
        }
    }

}
