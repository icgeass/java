package com.zeroq6.java.design_pattern.action.responsible_chain;

public class ConcreteHandler1 extends Handler {

    public ConcreteHandler1(Handler next, RequestType handlerType) {
        super(next, handlerType);
    }

    @Override
    public void handleRequest(Request request) {
        System.out.println("ConcreteHandler1 handle " + request.getRequestData());
    }
}
