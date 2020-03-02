package com.zeroq6.java.design_pattern.create.builder;


import com.alibaba.fastjson.JSON;

/**
 * 将一个复杂对象的构建与它的表示分离，
 * 使得同样的构建过程可以创建不同的表示
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
