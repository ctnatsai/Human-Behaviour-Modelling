package net.obviam.bt.ai;

import net.obviam.bt.World;

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

    public static Routine IsAttackVectorDeployed() {
        return new IsAttackVectorDeployed();
    }

    public static Routine developRelationship(Routine sequence, Routine sequence1) {
        return Routine.establishCommunication();
    }

    public static Routine exploitRelationship(Routine sequence, Routine selector) {
        return null;
    }
}
