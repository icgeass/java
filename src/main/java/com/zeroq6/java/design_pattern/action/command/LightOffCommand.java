package com.zeroq6.java.design_pattern.action.command;

/**
 * 具体命令
 */
public class LightOffCommand implements Command{
    private Receiver receiver;
    public LightOffCommand(Receiver receiver) {
        this.receiver = receiver;
    }
    public void execute() {
        receiver.turnOFF();
    }
}
