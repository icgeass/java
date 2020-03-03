package com.zeroq6.java.design_pattern.action.command;
/**
 * 测试类
 *
 * Receiver实现所有命令方法,构造传入所有命令中,每个命令调用Receiver相应方法
 *
 *
 * Invoker接收命令并调用命令的执行方法
 *
 */
public class Client {
    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        Invoker invoker = new Invoker();
        Command turnOnLight = new LightOnCommand(receiver);
        Command turnOffLight = new LightOffCommand(receiver);
        invoker.execute(turnOnLight);
        invoker.execute(turnOffLight);
    }
}
