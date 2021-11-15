package com.zeroq6.java.design_pattern.action.responsible_chain;


/**
 * 实际使用过程中用list来构造责任链,并用spring注入依赖到Processor
 */
public class Client {

    public static void main(String[] args) {
        // 用处理器中的handler链表依次处理请求对象直到请求第一次被处理为止
        Processor processor = new Processor();
        processor.process(new Request(RequestType.REQUEST_TYPE_A, "request1"));
        processor.process(new Request(RequestType.REQUEST_TYPE_B, "request2"));
        processor.process(new Request(null, "request3"));

    }
}
