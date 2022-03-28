package com.zeroq6.java.design_pattern.action.state;

/**
 * https://www.cnblogs.com/yssjun/p/11116652.html
 * Washing相当于Context
 * Start, Work, End相当于ConcreteState
 *
 * Context被动通过状态改变来表现出不同的行为
 * 每个状态行为结束后,将Context的状态设置为下一个状态,然后调用Context让其表现出其他状态的行为
 * （状态模式的核心是将对象每一个状态做的事情分别交给每一个单独的状态对象处理，并且由状态自己控制向其他状态的转移；行为类仅向外提供方便用户使用的接口；）
 *
 * Allow an object to alter its behavior when its internal state changes. The
 * object will appear to change its class.
 * 意思是：当一个对象内在状态改变时允许改变行为，这个对象看起
 * 来像改变了其类型。
 */
public class Client {
    public static void main(String[] args) {
        Washing washing = new Washing();
        washing.setState(new Start());
        washing.request();
    }
}


