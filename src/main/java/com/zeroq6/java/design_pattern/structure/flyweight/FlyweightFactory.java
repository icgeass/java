package com.zeroq6.java.design_pattern.structure.flyweight;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FlyweightFactory {
    private final static Map<String, Flyweight> pool = new ConcurrentHashMap<>();

    private FlyweightFactory() {
    } // 私有构造方法

    public static Flyweight getFlyweight(String intrinsicState) {
        Flyweight flyweight = pool.get(intrinsicState);
        if (flyweight == null) {
            synchronized (FlyweightFactory.class) {
                flyweight = pool.get(intrinsicState);
                if (flyweight == null) {
                    flyweight = new ConcreteFlyweight(intrinsicState);
                    pool.put(intrinsicState, flyweight);
                }

            }
        }
        return flyweight;
    }
}
