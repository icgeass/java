package com.zeroq6.java.other.tree;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.ArrayList;
import java.util.List;

/**
 * @author you@example.com
 * @date 2018/4/20
 */
public class GenTreeTest {


    final static List<Node> list = new ArrayList<Node>();

    public static void main(String[] args) {
        list.add(new Node("0", null, "根节点"));
        list.add(new Node("1", "0", "节点1"));
        list.add(new Node("2", "0", "节点2"));
        list.add(new Node("11", "1", "节点11"));
        list.add(new Node("12", "1", "节点12"));
        list.add(new Node("13", "1", "节点13"));
        list.add(new Node("131", "13", "节点131"));
        list.add(new Node("1311", "131", "节点1311"));
        list.add(new Node("1312", "131", "节点1312"));
        list.add(new Node("21", "2", "节点21"));
        list.add(new Node("22", "2", "节点22"));

        //
        Node root = list.get(0);

        proc(root);
        System.out.println(JSON.toJSONString(root, SerializerFeature.PrettyFormat));

    }


    public static void proc(Node node) {
        List<Node> childrenList = getChildrenNode(node);

        if (null != childrenList && !childrenList.isEmpty()) {
            for (Node item : childrenList) {
                proc(item);
                item.setParentNode(node);
            }
        }
        node.setChildNodeList(childrenList);


    }

    public static List<Node> getChildrenNode(Node node) {
        List<Node> cList = new ArrayList<Node>();
        for (Node item : list) {
            if (node.getId().equals(item.getParentId())) {
                cList.add(item);
            }
        }
        return cList;
    }


}
