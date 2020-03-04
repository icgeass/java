package com.zeroq6.java.design_pattern.action.visitor;

/**
 * 角色介绍
 *
 * Visitor：接口或者抽象类，定义了对每个 Element 访问的行为，它的参数就是被访问的元素，它的方法个数理论上与元素的个数是一样的，因此，访问者模式要求元素的类型要稳定，如果经常添加、移除元素类，必然会导致频繁地修改 Visitor 接口，如果出现这种情况，则说明不适合使用访问者模式。
 * ConcreteVisitor：具体的访问者，它需要给出对每一个元素类访问时所产生的具体行为。
 * Element：元素接口或者抽象类，它定义了一个接受访问者（accept）的方法，其意义是指每一个元素都要可以被访问者访问。
 * ElementA、ElementB：具体的元素类，它提供接受访问的具体实现，而这个具体的实现，通常情况下是使用访问者提供的访问该元素类的方法。
 * ObjectStructure：定义当中所提到的对象结构，对象结构是一个抽象表述，它内部管理了元素集合，并且可以迭代这些元素提供访问者访问。
 *
 * 作者：JamFF
 * 链接：https://www.jianshu.com/p/1f1049d0a0f4
 * 来源：简书
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Client {
    public static void main(String[] args) {
        Visitor visitor = new ConcreteVisitor();
        ObjectStruct objectStruct = new ObjectStruct();
        objectStruct.addElement(new ConcreteElement1("e1"));
        objectStruct.addElement(new ConcreteElement2("e2"));
        objectStruct.accept(visitor);

    }
}
