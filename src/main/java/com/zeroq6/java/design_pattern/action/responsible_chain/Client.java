package com.zeroq6.java.design_pattern.action.responsible_chain;


/**
 * 实际使用过程中用list来构造责任链,并用spring注入依赖到Processor
 */
public class Client {

    public static void main(String[] args) {
        Processor processor = new Processor();
        processor.process(new Request(RequestType.REQUEST_TYPE_A, "request1"));
        processor.process(new Request(RequestType.REQUEST_TYPE_B, "request2"));
        processor.process(new Request(null, "request3"));

    }
}
