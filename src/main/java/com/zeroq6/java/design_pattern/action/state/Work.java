package com.zeroq6.java.design_pattern.action.state;

public class Work implements State{
    @Override
    public void doJob(Washing washing) {
        System.out.println("Working Now!");
        washing.setState(new End());
        washing.request();
    }
}
