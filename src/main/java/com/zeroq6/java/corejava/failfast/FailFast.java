package com.zeroq6.java.corejava.failfast;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FailFast {


    public static void main(String[] args) {
        fail(new HashMap<>());
        fail(new ConcurrentHashMap<>());

    }


    private static void fail(Map<String, String> map) {
        map.put("Apple", "iPhone");
        map.put("HTC", "HTC one");
        map.put("Samsung", "S5");

        Iterator iterator = map.keySet().iterator();
        try {
            while (iterator.hasNext()) {
                System.out.println(map.get(iterator.next()));
                map.put("Sony", "Xperia Z");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
