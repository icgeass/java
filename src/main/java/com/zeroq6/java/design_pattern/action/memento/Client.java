package com.zeroq6.java.design_pattern.action.memento;



public class Client {

    public static void main(String[] args) {
        //
        Caretaker caretaker = new Caretaker();
        Originator originator = new Originator();
        originator.setState("1");
        originator.showState();
        caretaker.add(originator.backupStateToMemento());
        System.out.println("--------------");
        originator.setState("2");
        originator.showState();
        System.out.println("--------------");
        originator.restoreStateFromMemento(caretaker.get(0));
        originator.showState();

    }
}
