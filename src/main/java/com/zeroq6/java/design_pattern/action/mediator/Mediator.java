package com.zeroq6.java.design_pattern.action.mediator;

abstract class Mediator {

public abstract void register(Colleague colleague);

public abstract void relay(Colleague cl);

}

