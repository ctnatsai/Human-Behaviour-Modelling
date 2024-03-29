package net.obviam.bt.Agent;

import net.obviam.bt.Agent.AI.Memory.*;
import net.obviam.bt.Agent.Behaviour_Tree.*;
import net.obviam.bt.World_Setup.*;

public class Agent {

    Random_Access_Memory memory = new Random_Access_Memory();
    int range =5;
    int damage = 5;
    int health= 5;
    final String actor;
    int goal;
    Personality_Composition personality_composition;
    General_Experiences general_experiences;


    Routine routine;
    World world;

    public Agent(String actor, int goal, Personality_Composition personality_composition, General_Experiences general_experiences){
        this.actor = actor;
        this.goal = goal;
        this.personality_composition = personality_composition;
        this.general_experiences = general_experiences;
    }

    public String getActor() {
        return actor;
    }

    public void update() {
        if (routine.getState() == null) {
            // hasn't started yet so we start it
            routine.start();
        }
        routine.act(this, world);
    }

    public void start(){
        update();
    }

    public int getGeneralExperiences() {
        return general_experiences.getExperience();
    }

    public void setGeneralExperiences(General_Experiences general_experiences) {
        this.general_experiences = general_experiences;
    }

    public Random_Access_Memory getMemory(){
        return memory;
    }

    public void updateMemory(int event){
        this.memory.push(event);
    }

    public int getGoal() {
        return goal;
    }

    public void setGoal(int goal) {
        this.goal = goal;
    }

    public Personality_Composition getPersonality_Composition() {
        return personality_composition;
    }

    public void setPersonality_Composition(Personality_Composition personality_composition) {
        this.personality_composition = personality_composition;
    }

    //getTaskProgress was more or less like saying, agent, get coordinates. To check if not
    //another agent is occupying the same position that another agent has aspirations of occupying.

    public int getTaskProgress() {
        return goal;
    }

    public void setTaskProgress(int goal) {
        this.goal = goal;
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
        return actor;
    }

    public void setWorld(World world) {
            this.world = world;
     }

    @Override
    public String toString() {
        return  "x";
    }
}
