package com.zeroq6.java.design_pattern.action.mediator;

abstract class Colleague {

protected Mediator mediator;

public void setMedium(Mediator mediator) {

this.mediator = mediator;

}

public abstract void receive();

public abstract void send();

}
