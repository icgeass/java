package com.zeroq6.java.design_pattern.structure.facade;

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
