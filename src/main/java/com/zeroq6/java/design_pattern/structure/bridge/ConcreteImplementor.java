package com.zeroq6.java.design_pattern.structure.bridge;

public class ConcreteImplementor implements Implementor {
    //方法的实现化实现
    public void operationImp() {
    // 业务处理代码
        System.out.println("ConcreteImplementor.operationImp");
    }
}