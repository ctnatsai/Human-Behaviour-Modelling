package net.obviam.bt;

import net.obviam.bt.ai.Routine;

public class Agent {

    final String name;
    int x;
    int y;
    int range;
    int damage;
    int health;

    Routine routine;
    World world;

    public Agent(String name, int x, int y, int health, int damage, int range) {
        this.name = name;
        this.x = x;
        this.y = y;
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

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
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
        return "Agent{" +
                "name=" + name +
                ", x=" + x +
                ", y=" + y +
                ", health=" + health +
                ", range=" + range +
                ", damage=" + damage +
                '}';
    }
}
