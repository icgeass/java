package com.zeroq6.java.design_pattern.action.command;

/**
 * Created by zengjianlu on 2018/2/24.
 * <p>
 * 命令调用者：负责调用
 * <p>
 * https://zhuanlan.zhihu.com/p/64403849
 */
public class Invoker {
    public void execute(Command command) {
        command.execute();
    }
}
