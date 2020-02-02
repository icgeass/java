package com.zeroq6.java.middleware.zookeeper;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;

/**
 * 应用上下线
 *
 * @author
 */
public class TestAlive extends TestZookeeperBase {


    public static void main(String[] args) throws Exception {
        TestZookeeperBase testZookeeperBase = new TestZookeeperBase();

        testZookeeperBase.connect();

        // watcher不是永久的,触发之后需要重新watch
        TestZookeeperBase.watchAgain = true;

        //zookeeper配置数据存放路径
        TestZookeeperBase.zk.create("/test_alive_", "I am alive".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL, (rc, reqPath, ctx, name) -> {
            System.out.println("rc=" + rc);
            System.out.println("reqPath=" + reqPath);
            System.out.println("ctx=" + ctx);
            System.out.println("name=" + name);

        }, "this ctx?");
        Thread.sleep(Integer.MAX_VALUE);

    }


}