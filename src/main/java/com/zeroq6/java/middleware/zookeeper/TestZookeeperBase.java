package com.zeroq6.java.middleware.zookeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.util.concurrent.CountDownLatch;

/**
 * @author
 */
public class TestZookeeperBase implements Watcher {

    protected static CountDownLatch connectedSemaphore = new CountDownLatch(1);
    protected static boolean watchAgain;
    protected static ZooKeeper zk;

    protected static Stat stat = new Stat();



    protected void connect() {
        try {
            //连接zookeeper并且注册一个默认的监听器
            zk = new ZooKeeper("127.0.0.1:2181", 5000, new TestZookeeperBase());
            //等待zk连接成功的通知
            connectedSemaphore.await();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("-------------------");
        }
    }

    public void process(WatchedEvent event) {
        System.out.println("EventType=" + event.getType().name());
        System.out.println("KeeperState=" + event.getState().name());
        if (KeeperState.SyncConnected == event.getState()) {  //zk连接成功通知事件
            if (EventType.None == event.getType() && null == event.getPath()) {
                connectedSemaphore.countDown();
            } else if (event.getType() == EventType.NodeDataChanged) {  //zk目录节点数据变化通知事件
                try {
                    if (watchAgain) {
                        System.out.println("配置已修改，新值为：" + new String(zk.getData(event.getPath(), true, stat)));
                    } else {
                        System.out.println("配置已修改，路径为：" + event.getPath());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
    }
}