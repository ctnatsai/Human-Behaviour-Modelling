package net.obviam.bt.Target_AI;


import net.obviam.bt.Target_AI.Perception.Perceive;
import net.obviam.bt.World;
import net.obviam.bt.Target_AI.Perception_Interface.*;
import net.obviam.bt.Target_AI.Perception.*;
import net.obviam.bt.Target_AI.DeployAttackVector;

/**
 * Static convenience methods to create routines
 */
public class Routines {

    public static Routine sequence(Routine... routines) {
        Sequence sequence = new Sequence();
        for (Routine routine : routines) {
            sequence.addRoutine(routine);
        }
        return sequence;
    }

    public static Routine selector(Routine... routines) {
        Selector selector = new Selector();
        for (Routine routine : routines) {
            selector.addRoutine(routine);
        }
        return selector;
    }

    public static Routine task(int task) {
        return new Task(task);
    }

    public static Routine repeatInfinite(Routine routine) {
        return new Repeat(routine);
    }

    public static Routine repeat(Routine routine, int times) {
        return new Repeat(routine, times);
    }

    public static Routine work(World world) {
        return new Work(world);
    }

    public static Routine drinkCoffee(World world) { return new DrinkCoffee(world); }

    public static Routine sensor() { return new Sensor(); }

    public static Routine perceive() { return new Perceive(); }

    public static Routine deployAttackVector(int attack_vector) { return new DeployAttackVector(attack_vector); }

}
