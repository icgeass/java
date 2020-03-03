package com.zeroq6.java.design_pattern.action.responsible_chain;

public class ConcreteHandler2 extends Handler {

    public ConcreteHandler2(Handler next, RequestType handlerType) {
        super(next, handlerType);
    }

    @Override
    public void handleRequest(Request request) {
        System.out.println("ConcreteHandler2 handle " + request.getRequestData());
    }
}
