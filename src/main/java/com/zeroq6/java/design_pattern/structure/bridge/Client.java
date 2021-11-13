package com.zeroq6.java.design_pattern.structure.bridge;


/**
 *
 * Decouple an abstraction from its implementation so that the two can
 * vary independently.
 * 意思是：将抽象和实现解耦，使得两者可以独立地变化。
 *
 * 和适配器模式的区别在于**是否修正**,Abstraction是抽象类
 * <p>
 * 桥接模式和适配器模式的区别
 * 很多时候经常容易把桥接模式和适配器模式弄混。那什么时候用桥接，什么时候用适配器呢 ？  
 * <p>
 * 共同点：
 * 桥接和适配器都是让两个东西配合工作 
 * 不同点：出发点不同。          
 * 　　适配器：改变已有的两个接口，让他们相容。  
 * 　　桥接模式：分离抽象化和实现，使两者的接口可以不同，目的是分离。  
 * ————————————————
 * 版权声明：本文为CSDN博主「迷死特兔」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/cooldragon/article/details/52173915
 */
public class Client {

    // 将Implementor接口桥接到Abstraction，Abstraction的实现类保存了Implementor实现类，
    // Implementor和Abstraction接口分类开来
    public static void main(String[] args) {
        // 定义一个实现化角色
        Implementor imp = new ConcreteImplementor();
        // 定义一个抽象化角色
        Abstraction abs = new RefinedAbstraction(imp);
        // 执行
        abs.operation();
    }
}
