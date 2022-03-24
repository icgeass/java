package com.zeroq6.java.design_pattern.create.builder;


import com.alibaba.fastjson.JSON;

/**
 * 将一个复杂对象的构建与它的表示分离，
 * 使得同样的构建过程可以创建不同的表示（比如构建顺序不同，创建的产品表示不同）
 *
 * 如果用构造方法，那么成员变量多的时候难以维护，且构建过程和表示耦合（没有分离）
 *
 * 这里的Client相当于指挥者Director角色
 */
public class Client {

    public static void main(String[] args) {
        Builder builder = new ConcreteBuilder();
        Product product = builder.setPart1("p1").setPart2("p2").build();
        System.out.println(JSON.toJSONString(product));
    }
}
