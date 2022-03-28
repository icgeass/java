package com.zeroq6.java.design_pattern.action.iterator;

/**
 * 类似于ArrayList的迭代器（传统遍历size()，get(i)暴露了细节）
 *
 * 提供一种方法访问一个容器对象中各个元素，而又不需暴露该对象的内部细节。
 */
public class Client {
    public static void main(String[] args) {
        // 定义聚集对象
        Aggregate agg = new ConcreteAggregate();
        agg.add("张三");
        agg.add("李四");
        agg.add("王五");
        // 遍历
        Iterator iterator = agg.createIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
