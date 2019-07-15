package com.zeroq6.java.corejava.array;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashSet;

public class ArrayListTest {
    public static void main(String[] args) {

        // 将list转换位数组类型
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        //
        Integer[] integers = arrayList.toArray(new Integer[0]);
        System.out.println(JSON.toJSONString(integers));


        // 构造数组类型
        String[] strings = (String[]) java.lang.reflect.Array.newInstance(String[].class.getComponentType(), 10);
        strings[0] = "1";
        strings[1] = "2";
        strings[9] = "9";
        System.out.println(JSON.toJSONString(strings));

        //
        String str1 = "通话";
        String str2 = "重地";
        System.out.println(String.format("str1：%d | str2：%d", str1.hashCode(), str2.hashCode()));
        System.out.println(str1.equals(str2));



    }


}
