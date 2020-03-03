package com.zeroq6.java.design_pattern.action.template_method;

public class ConcreteClass extends AbstractClass {
    // 实现基本业务方法
    protected void operation() {
        // 业务逻辑
        System.out.println("自定义业务逻辑");
    }
}
