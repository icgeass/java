package com.zeroq6.java.misc;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ZsxqUtils {


    public static void main(String[] args) throws Exception {

        String fileDir = "E:\\知识星球\\老齐的读书圈";
        List<String> indexList = Collections.unmodifiableList(FileUtils.readLines(new File(fileDir + File.separator + "目录.txt"), "utf-8").stream().filter(s -> StringUtils.isNotBlank(s) && !s.startsWith("http") && !s.contains("#") && !s.contains("=")).collect(Collectors.toList()));
        int digitLength = 4;
        List<String> nameList = FileUtils.listFiles(new File(fileDir + File.separator + "文件"), null, true).stream().map(file ->
                file.getName()).collect(Collectors.toList());


        List<String> listCopy = new ArrayList<>(indexList);

        for (String name : nameList) {
            String title = name.replace(".mp3", "").replace(".docx", "")
                    .replace("（合集）上", "").replace("（合集）中", "")
                    .replace("（合集）下", "").replace("（合集）", "")
                    .replace("修改", "").replace("（2019补充）", "");
            boolean findIt = false;
            if (name.startsWith("[")) {
                System.out.println(name + " already renamed");
                String indexName = title.substring(1, digitLength + 1) + title.substring(digitLength + 2);
                if (indexList.contains(indexName)) {
                    continue;
                } else {
                    throw new RuntimeException("can not find " + name + " in .txt");
                }
            }
            for (String string : indexList) {
                String num = string.substring(0, digitLength);
                if (string.substring(digitLength).equals(title)) {
                    listCopy.remove(string);
                    if (findIt) {
                        System.err.println("more than 1 match, " + name);
                        break;
                    } else {
                        System.out.println(name + "---->[" + num + "]" + name);
                        // uncomment it when all match and only match one times
//                        FileUtils.moveFile(new File(fileDir + File.separator + name), new File(fileDir + File.separator + "[" + num + "]" + name));
                        findIt = true;
                    }
                }
            }
            if (!findIt) {
                System.err.println("not found match, " + name);
            }
        }
        for (String s : listCopy) {
            System.out.println("not download, " + s);
        }


    }

}
