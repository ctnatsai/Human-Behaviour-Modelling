package net.obviam.bt;

import net.obviam.bt.ai.Routine;

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

    public void setBoard(World world) {
            this.world = world;
     }

    @Override
    public String toString() {
        return  "name=" + name +
                ", performingTaskId=" + task +
                ", health=" + health;
    }
}
