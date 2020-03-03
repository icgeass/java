package com.zeroq6.java.design_pattern.action.mediator;

public class ConcreteColleague3 extends Colleague {

    public void receive() {

        System.out.println("具体同事类3收到请求。");

    }

    public void send() {

        System.out.println("具体同事类3发出请求。");

        mediator.relay(this);

    }

}

