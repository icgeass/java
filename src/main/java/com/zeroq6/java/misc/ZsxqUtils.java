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
        List<String> list = FileUtils.readLines(new File(fileDir + File.separator + "目录.txt"), "utf-8");
        list.remove(0);
        list.remove(0);
        int digitLength = 4;
        List<String> nameList = FileUtils.listFiles(new File(fileDir + File.separator + "文件"), null, true).stream().map(file ->
                file.getName()).collect(Collectors.toList());


        List<String> list2 = new ArrayList<>(list);

        for (String name : nameList) {
            String title = name.replace(".mp3", "").replace(".docx", "")
                    .replace("（合集）上", "").replace("（合集）中", "")
                    .replace("（合集）下", "").replace("（合集）", "")
                    .replace("修改", "").replace("（2019补充）", "");
            boolean findIt = false;
            if (name.startsWith("[")) {
                System.out.println(name + " already renamed");
                continue;
            }
            for (String string : Collections.unmodifiableList(list)) {
                if (StringUtils.isBlank(string) || string.contains("http")) {
                    list2.remove(string);
                    continue;
                }
                String num = string.substring(0, digitLength);
                if (string.substring(digitLength).equals(title)) {
                    list2.remove(string);
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
        for (String s : list2) {
            System.out.println("not download, " + s);
        }


    }

}
