package com.zeroq6.java.middleware.zookeeper;

/**
 * 分布式配置中心demo
 *
 * @author
 */
public class TestWatch extends TestZookeeperBase {


    public static void main(String[] args) throws Exception {
        TestZookeeperBase testZookeeperBase = new TestZookeeperBase();

        testZookeeperBase.connect();

        // watcher不是永久的,触发之后需要重新watch
        TestZookeeperBase.watchAgain = true;
        //zookeeper配置数据存放路径
        String path = "/test_watch";
        //获取path目录节点的配置数据，并注册默认的监听器
        System.out.println(new String(testZookeeperBase.zk.getData(path, true, testZookeeperBase.stat)));

        Thread.sleep(Integer.MAX_VALUE);
    }


}