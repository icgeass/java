package com.zeroq6.java.design_pattern.action.responsible_chain;

public class Processor {

    private Handler chain;

    public Processor() {
        chain = new ConcreteHandler1(new ConcreteHandler2(null, RequestType.REQUEST_TYPE_B), RequestType.REQUEST_TYPE_A);
    }

    public void process(Request request) {
        Handler handler = chain;
        while (handler != null) {
            if (handler.handleIt(request)) {
                handler.handleRequest(request);
                return;
            } else {
                handler = handler.getNext();
            }
        }
        System.out.println("No handler found for " + request);
    }
}
