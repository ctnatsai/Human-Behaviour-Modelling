package net.obviam.bt;

import net.obviam.bt.Target_AI.Routine;

public class Agent {

    final String name;
    int task;
    int range;
    int damage;
    int health;

    Routine routine;
    World world;

    public Agent(String name, int task, int health, int damage, int range) {
        this.name = name;
        this.task = task;
        this.health = health;
        this.damage = damage;
        this.range = range;
    }

    public void update() {
        if (routine.getState() == null) {
            // hasn't started yet so we start it
            routine.start();
        }
        routine.act(this, world);
    }

    //getTaskProgress was more or less like saying, agent, get coordinates. To check if not
    //another agent is occupying the same position that another agent has aspirations of occupying.
    public int getTaskProgress() {
        return task;
    }

    public void setTaskProgress(int task) {
        this.task = task;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public Routine getRoutine() {
        return routine;
    }

    public void setRoutine(Routine routine) {
        this.routine = routine;
    }

    public String getName() {
        return name;
    }

    public void setWorld(World world) {
            this.world = world;
     }

    @Override
    public String toString() {
        return  "name=" + name +
                ", performingTaskId=" + task +
                ", health=" + health;
    }
}
