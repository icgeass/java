package com.zeroq6.java.design_pattern.action.state;

public class End implements State{
    @Override
    public void doJob(Washing washing) {
        System.out.println("All Finished!");
        washing.setState(null);
    }
}
