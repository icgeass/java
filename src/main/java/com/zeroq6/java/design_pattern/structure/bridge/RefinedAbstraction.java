package com.zeroq6.java.design_pattern.structure.bridge;

//修正抽象化角色
public class RefinedAbstraction extends Abstraction {
    public RefinedAbstraction(Implementor imp) {
        super(imp);
    }

    //修正父类的方法
    public void operation() {
        System.out.println("修正结束");
        this.imp.operationImp();
        System.out.println("修正结束");
    }
}
