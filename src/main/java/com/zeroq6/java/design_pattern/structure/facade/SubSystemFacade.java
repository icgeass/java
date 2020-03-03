package com.zeroq6.java.design_pattern.structure.facade;


public class SubSystemFacade {
    private SubSystemA subSystemA = new SubSystemA();
    private SubSystemB subSystemB = new SubSystemB();
    private SubSystemC subSystemC = new SubSystemC();


    public void a() {
        subSystemA.a();
    }

    public void ab() {
        subSystemA.a();
        subSystemB.b();

    }

    public void cc() {
        subSystemC.c1();
        subSystemC.c2();
    }
}
