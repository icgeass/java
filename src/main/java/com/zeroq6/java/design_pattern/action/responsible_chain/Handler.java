package com.zeroq6.java.design_pattern.action.responsible_chain;

public abstract class Handler {
    private Handler next;

    private RequestType handlerType;


    public Handler(Handler next, RequestType handlerType) {
        this.next = next;
        this.handlerType = handlerType;
    }

    public Handler getNext() {
        return next;
    }

    public RequestType getHandlerType() {
        return handlerType;
    }

    public boolean hasNext(){
        return next != null;
    }

    public boolean handleIt(Request request){
        return null != request && request.getRequestType() == handlerType;
    }

    public abstract void handleRequest(Request request);
}
