package com.zeroq6.java.design_pattern.structure.composite;


/**
 * Compose objects into tree structures to represent part-whole hierarchies.
 * Composite lets clients treat individual objects and compositions of objects
 * uniformly.
 * 意思是：将对象组合成树形结构以表示“部分—整体”的层次结构，
 * 使得用户对单个对象和组合对象的使用具有一致性。
 */
public class Client {


    public static void main(String[] args) {
        //
        File root = new Folder("root");
        File folder1 = new Folder("folder1");
        File folder2 = new Folder("folder2");

        File file1 = new VideoFile("file1");
        File file2 = new TextFile("file2");
        File file3 = new TextFile("file3");
        File file4 = new VideoFile("file4");
        File file5 = new TextFile("file5");

        root.add(folder1);
        root.add(file1);
        root.add(file2);
        folder1.add(file3);
        folder1.add(folder2);
        folder2.add(file4);
        folder2.add(file5);
        System.out.println("-----------------------");
        // 打印
        root.display();
        folder1.display();
        folder2.display();
        file1.display();


    }
}
