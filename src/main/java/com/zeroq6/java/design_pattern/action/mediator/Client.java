package com.zeroq6.java.design_pattern.action.mediator;


/**
 * https://www.jianshu.com/p/4409addf8ad1?from=groupmessage&isappinstalled=0
 *
 * 用一个中介对象封装一系列对象（同事）的交互，中介者使各对象不需要显式地相互作用，从而使其耦合松散，而且可以独立地改变它们之间的交互。
 */
public class Client {

    public static void main(String[] args) {

        Mediator mediator = new ConcreteMediator();
        Colleague colleague1, colleague2, colleague3;
        colleague1 = new ConcreteColleague1();
        colleague2 = new ConcreteColleague2();
        colleague3 = new ConcreteColleague3();

        mediator.register(colleague1);
        mediator.register(colleague2);
        mediator.register(colleague3);
        colleague1.send();
        System.out.println("----------------");
        colleague2.send();

    }
}

