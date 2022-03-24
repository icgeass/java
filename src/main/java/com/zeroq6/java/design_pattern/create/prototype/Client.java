package com.zeroq6.java.design_pattern.create.prototype;

import com.alibaba.fastjson.JSON;

/**
 * 用一个已经创建的实例作为原型，通过复制该原型对象来创建一个和原型相同或相似的新对象
 */
public class Client {

    public static void main(String[] args){
        Prototype prototype = new ConcretePrototype("test");
        System.out.println(JSON.toJSONString(prototype));
        Prototype clone = prototype.cloneInstance();
        System.out.println(JSON.toJSONString(clone));
    }
}
