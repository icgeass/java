package com.zeroq6.java.design_pattern.structure.decoretor;


/**
 *
 * 动态地给一个对象添加一些额外的职责。就增加功能来
 * 说，装饰模式比生成子类更为灵活。
 *
 *
 * 动态添加职责,可以累加等
 *
 * 具体组件和装饰器都实现组件接口，通过构造方法将组件传入装饰器，再将得到的装饰器继续构造传入另一个装饰器，依此类推，套娃。
 * 装饰器执行组件接口方法先执行自己方法，再执行组件方法，得到的效果就是组件的方法从外层装饰器开始，一层层被装饰
 */
public class Client {
    public static void main(String[] args) {
        Decorator2 decorator2 = new Decorator2(new Decorator1(new ConcreteComponent()));
        decorator2.operate();
    }
}
