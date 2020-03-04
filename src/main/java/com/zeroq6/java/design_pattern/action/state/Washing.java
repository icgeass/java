package com.zeroq6.java.design_pattern.action.state;

public class Washing {
    private State state = null;

    public void setState(State state) {
        System.out.println("--------------");
        this.state = state;
        if (state == null) {
            System.out.println("Current state: null!");
        }
        else {
            System.out.println("Current state: " + state.getClass().getSimpleName());
        }
    }

    public void request() {
        if (state != null) {
            state.doJob(this);
        }
    }
}
