package com.zeroq6.java.design_pattern.action.template_method;

public abstract class AbstractClass {
    //基本方法
    protected abstract void operation();

    //模板方法
    public void templateMethod() {
        //调用基本方法，完成相关的逻辑
        System.out.println("初始化");
        this.operation();
        System.out.println("后置处理");
    }
}
