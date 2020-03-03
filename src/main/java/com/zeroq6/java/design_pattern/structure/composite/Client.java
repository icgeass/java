package com.zeroq6.java.design_pattern.structure.composite;

import com.alibaba.fastjson.JSON;

/**
 * 将对象组合成树形结构以表示“部分—整体”的层次结构，使得用户对单个对象和组合对象的使用具有一致性
 */
public class Client {


    public static void main(String[] args) {
        Component component1 = new Composite("composite1");

        component1.operate();
        component1.add(new Leaf("leaf11"));
        component1.add(new Leaf("leaf12"));
        component1.remove(new Leaf("leaf11"));
        System.out.println(JSON.toJSONString(component1.getChildren()));

        System.out.println("------------------------");

        Component component2 = new Leaf("leaf2");

        component2.operate();
        component2.add(new Leaf("xxxx1"));
        component2.add(new Leaf("xxxx2"));
        component2.remove(new Leaf("xxxx1"));
        System.out.println(JSON.toJSONString(component2.getChildren()));



    }
}
