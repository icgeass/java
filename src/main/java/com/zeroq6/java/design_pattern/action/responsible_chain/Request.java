package com.zeroq6.java.design_pattern.action.responsible_chain;

public class Request {
    private RequestType requestType;
    private String requestData;

    public Request(RequestType requestType, String requestData) {
        this.requestType = requestType;
        this.requestData = requestData;
    }

    public RequestType getRequestType() {
        return requestType;
    }

    public void setRequestType(RequestType requestType) {
        this.requestType = requestType;
    }

    public String getRequestData() {
        return requestData;
    }

    public void setRequestData(String requestData) {
        this.requestData = requestData;
    }
}
