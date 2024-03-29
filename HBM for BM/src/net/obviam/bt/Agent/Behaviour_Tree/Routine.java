package net.obviam.bt.Agent.Behaviour_Tree;

import net.obviam.bt.Agent.*;
import net.obviam.bt.World_Setup.*;

public abstract class Routine {
    public enum RoutineState {
        Success,
        Failure,
        Running
    }

    protected RoutineState state;

    protected Routine() { }

    public void start() {
        this.state = RoutineState.Running;
        //System.out.println(this.toString(this.state));

        if (!(this.getClass().getSimpleName().equals("Repeat") ||
                this.getClass().getSimpleName().equals("Selector") ||
                this.getClass().getSimpleName().equals("Sequence"))){
            //System.out.println(">>> Starting routine: " + this.getClass().getSimpleName()) ;
            //System.out.println("Starting" + this.getClass().getSimpleName());
            return;
        }
    }

    public abstract void reset();

    public abstract void act(Agent agent, World world);

    protected void succeed() {
        //System.out.println(">>> Routine: " + this.getClass().getSimpleName() + " SUCCEEDED");
        this.state = RoutineState.Success;
    }

    protected void fail() {
        //System.out.println(">>> Routine: " + this.getClass().getSimpleName() + " FAILED");
        this.state = RoutineState.Failure;
    }

    public boolean isSuccess() {
        return state.equals(RoutineState.Success);
    }

    public boolean isFailure() {
        return state.equals(RoutineState.Failure);
    }

    public boolean isRunning() {
        return state.equals(RoutineState.Running);
    }

    public RoutineState getState() {
        return state;
    }
}
