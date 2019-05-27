package com.zeroq6.java.learn.corejava.clone;

import com.alibaba.fastjson.JSON;

import java.io.*;

/**
 * @author icgeass
 * @date 2018/7/10
 * <p>
 * 浅复制：只复制对象本身而不复制对象关联的引用
 * {@link Object#clone()}
 * <p>
 * 深复制，利用序列化，反序列化实现，对象本身属性，和关联对象和属性全部复制
 * 所有关联类必须实现{@link Serializable} 接口
 * <p>
 * https://segmentfault.com/a/1190000010648514
 */
public class TestClone {

    public static void main(String[] args) throws Exception {
        // 浅复制
        System.out.println("shallow clone: ");
        ClassA classA0 = new ClassA().setName("class a").setId(100001).setClassB(new ClassB().setName("class b").setClassC(new ClassC().setName("class c")));
        ClassA classA1 = (ClassA) classA0.clone();
        showClassInfo(classA0, classA1);
        // 深复制
        System.out.println("deep clone: ");
        ClassA classA2 = deepClone(classA0);
        showClassInfo(classA0, classA2);

    }


    @SuppressWarnings("unchecked")
    private static <T> T deepClone(T o) throws IOException, ClassNotFoundException {
        //将对象写到流里
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        ObjectOutputStream oo = new ObjectOutputStream(bo);
        oo.writeObject(o);
        //从流里读出来
        ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
        ObjectInputStream oi = new ObjectInputStream(bi);
        return (T) oi.readObject();
    }

    private static void showClassInfo(ClassA left, ClassA right) {
        System.out.println("-------left-------");
        System.out.println(JSON.toJSONString(left));
        System.out.println(left);
        System.out.println(left.getClassB());
        System.out.println(left.getClassB().getClassC());
        System.out.println("------right-------");
        System.out.println(JSON.toJSONString(right));
        System.out.println(right);
        System.out.println(right.getClassB());
        System.out.println(right.getClassB().getClassC());
        System.out.println("left.getId() == right.getId(): " + (left.getId() == right.getId()));

    }

}
