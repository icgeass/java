package com.zeroq6.java.design_pattern.structure.facade;

/**
 * 外观模式（Facade）：也叫门面模式，要求一个子系统的外部
 * 与其内部的通信必须通过一个统一的对象进行，外观模式提供一个高层次的接口，使得子系统更易于使用。
 */
public class Client {


    public static void main(String[] args) {
        SubSystemFacade subSystemFacade = new SubSystemFacade();
        subSystemFacade.a();
        System.out.println("--------------");
        subSystemFacade.ab();
        System.out.println("--------------");
        subSystemFacade.cc();
    }
}
