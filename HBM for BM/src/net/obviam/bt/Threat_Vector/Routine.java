package net.obviam.bt.Threat_Vector;

import net.obviam.bt.Agent;
import net.obviam.bt.World;

public abstract class Routine {

    public static Routine establishCommunication() {
        return null;
    }

    public static Routine buildRapport() {
        return null;
    }

    public static Routine primeTarget() {
        return null;
    }

    public static Routine agentDisclosesCredentials() {
        return null;
    }

    public static Routine agentDoesNotDiscloseCredentials() {
        return null;
    }

    public enum RoutineState {
        Success,
        Failure,
        Running
    }

    protected RoutineState state;

    protected Routine() { }

    public void start() {
        System.out.println(">>> Starting routine: " + this.getClass().getSimpleName()) ;
        this.state = RoutineState.Running;
    }

    public abstract void reset();

    public abstract void act(Agent agent, World world);

    protected void succeed() {
        System.out.println(">>> Routine: " + this.getClass().getSimpleName() + " SUCCEEDED");
        this.state = RoutineState.Success;
    }

    protected void fail() {
        System.out.println(">>> Routine: " + this.getClass().getSimpleName() + " FAILED");
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