package com.zeroq6.java.misc;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Triple;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ZsxqUtils {


    public static void main(String[] args) throws Exception {
        String baseFolder = "E:\\知识星球\\老齐的读书圈";
        String baseFolderIndex = baseFolder + File.separator + "目录.txt";
        String baseFolderFile = baseFolder + File.separator + "文件";
        //
        List<String> indexNameList = Collections.unmodifiableList(FileUtils.readLines(new File(baseFolderIndex), "utf-8").stream().filter(s -> StringUtils.isNotBlank(s) && !s.startsWith("http") && !s.contains("#") && !s.contains("=")).collect(Collectors.toList()));
        List<String> fileNameList = FileUtils.listFiles(new File(baseFolderFile), null, true).stream().map(File::getName).collect(Collectors.toList());
        //
        List<String> indexNameListCopy = new ArrayList<>(indexNameList);
        //
        final int digitLength = 4;
        final String begin = "[";
        final String end = "]";
        //
        List<Triple<File, String, File>> renameFilePair = new ArrayList<>();

        for (String fileName : fileNameList) {
            String title = findTitle(fileName);
            // 验证，如果文件已经重命名，那么从title（[0001]xxxx）中获取的indexName（0001xxxx）必然包含在indexNameList中
            if (fileName.startsWith(begin)) {
                String indexName = title.substring(title.indexOf(begin) + 1, title.indexOf(end)) + title.substring(title.indexOf(end) + 1);
                if (indexNameList.contains(indexName)) {
                    indexNameListCopy.remove(indexName);
                    continue;
                } else {
                    throw new RuntimeException("无法在目录文件中找到已重命名文件 " + fileName + " 的indexName" + indexName);
                }
            }
            boolean findTitleInIndexNameList = false;

            for (String indexName : indexNameList) {
                String num = indexName.substring(0, digitLength);
                if (findTitle(indexName.substring(digitLength)).equals(title)) {
                    // 余下的就是indexNameList里面没有被文件名匹配的，就是未下载的
                    indexNameListCopy.remove(indexName);
                    if (findTitleInIndexNameList) {
                        throw new RuntimeException("indexName" + indexName + "在目录文件中重复");
                    } else {
                        renameFilePair.add(Triple.of(new File(baseFolderFile + File.separator + fileName), indexName, new File(baseFolderFile + File.separator + "[" + num + "]" + fileName)));
                        findTitleInIndexNameList = true;
                    }
                }
            }
            if (!findTitleInIndexNameList) {
                throw new RuntimeException("未在目录文件中找到文件 " + fileName + "（title：" + title + "）的indexName");
            }
        }
        for (String remainNotMatchFileNameIndexName : indexNameListCopy) {
            throw new RuntimeException("文件 " + remainNotMatchFileNameIndexName + " 未下载");
        }
        // 重命名文件
        for (Triple<File, String, File> triple : renameFilePair) {
            File src = triple.getLeft();
            File des = triple.getRight();
            FileUtils.moveFile(src, des);
            System.out.println(src.getName() + " <---" + triple.getMiddle() + "---> " + des.getName());
        }


    }

    private static String findTitle(String name) {
        String title = name.replace("修改", "")
                .replaceAll("\\s+", "");
        String[] removeToRight = new String[]{"（", "合集", "修改", "."};
        for (String remove : removeToRight) {
            int endPos = title.indexOf(remove);
            if (endPos != -1) {
                title = title.substring(0, endPos);
            }
        }
        return title;
    }

}
