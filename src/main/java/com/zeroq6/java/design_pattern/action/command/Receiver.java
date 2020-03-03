package com.zeroq6.java.design_pattern.action.command;

/**
 *
 * 命令接收者：执行命令
 */
public class Receiver {
    public void turnON() {
        System.out.println("执行开灯操作...");
    }
    public void turnOFF() {
        System.out.println("执行关灯操作...");
    }
}
