package com.zeroq6.java.design_pattern.action.observer;

public interface Observer<S extends AbstractSubject<S, O, A>, O extends Observer<S, O, A>, A> {

    void update(S subject, A argument);
}


