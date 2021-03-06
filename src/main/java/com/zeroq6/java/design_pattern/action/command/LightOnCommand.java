package com.zeroq6.java.design_pattern.action.command;

/**
 *
 * 具体命令
 */
public class LightOnCommand implements Command{
    private Receiver receiver;
    public LightOnCommand(Receiver receiver) {
        this.receiver = receiver;
    }
    public void execute() {
        receiver.turnON();
    }
}
