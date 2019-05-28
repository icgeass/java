package com.zeroq6.java.other.tree;

import java.util.List;

public class Node {

    private Node parentNode;
    private String id;
    private String parentId;
    private String name;
    private List<Node> childNodeList;

    public Node() {
    }

    public Node(String id, String parentId, String name) {
        this.id = id;
        this.parentId = parentId;
        this.name = name;
    }

    public Node getParentNode() {
        return parentNode;
    }

    public void setParentNode(Node parentNode) {
        this.parentNode = parentNode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Node> getChildNodeList() {
        return childNodeList;
    }

    public void setChildNodeList(List<Node> childNodeList) {
        this.childNodeList = childNodeList;
    }
}
