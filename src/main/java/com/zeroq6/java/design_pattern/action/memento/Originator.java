package com.zeroq6.java.design_pattern.action.memento;

public class Originator {
    private String state;

    public void setState(String state){
        this.state = state;
    }

    public String getState(){
        return state;
    }

    public void showState(){
        System.out.println("state=" + state);
    }

    public Memento backupStateToMemento(){
        return new Memento(state);
    }

    public void restoreStateFromMemento(Memento Memento){
        state = Memento.getState();
    }
}
