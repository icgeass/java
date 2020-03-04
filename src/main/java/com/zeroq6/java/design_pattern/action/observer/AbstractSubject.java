package com.zeroq6.java.design_pattern.action.observer;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class AbstractSubject<S extends AbstractSubject<S, O, A>, O extends Observer<S, O, A>, A> {

    protected List<O> observers;

    protected String name;

    public AbstractSubject(String name) {
        this.name = name;
        this.observers = new CopyOnWriteArrayList<>();
    }

    public void addObserver(O observer) {
        this.observers.add(observer);
    }

    public void removeObserver(O observer) {
        this.observers.remove(observer);
    }

    /**
     * Notify observers.
     */
    @SuppressWarnings("unchecked")
    public void notifyObservers(A argument) {
        for (O observer : observers) {
            observer.update((S) this, argument);
        }
    }
}
