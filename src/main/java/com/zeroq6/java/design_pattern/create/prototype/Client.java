package com.zeroq6.java.design_pattern.create.prototype;

import com.alibaba.fastjson.JSON;

public class Client {

    public static void main(String[] args){
        Prototype prototype = new ConcretePrototype("test");
        System.out.println(JSON.toJSONString(prototype));
        Prototype clone = prototype.cloneInstance();
        System.out.println(JSON.toJSONString(clone));
    }
}
