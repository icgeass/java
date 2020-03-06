package com.zeroq6.java.misc;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.zeroq6.java.misc.util.HttpUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class FundInfo {


    public static void main(String[] args) throws IOException, URISyntaxException {
        File dataFile = new File(FundInfo.class.getClassLoader().getResource("misc/data.txt").getFile());
        String begin = "2019_4";
        String end = "2019_4";

        // 获取数据
        List<String> allDataList = new ArrayList<>();
        Map<String, List<String>> seasonDataMap = new HashMap<>();
        List<String> range = genRange(begin, end);
        System.out.println(JSON.toJSONString(range, SerializerFeature.PrettyFormat));
        for (String season : range) {
            List<String> data = loadData(season, 500);
            seasonDataMap.put(season, data);
            allDataList.addAll(data);
        }
        // 写入
        FileUtils.writeLines(dataFile, "utf-8", allDataList, false);
        System.out.println(dataFile.getCanonicalPath());

        // 生成csv
        genCsvFile(seasonDataMap, dataFile.getParent() + File.separator + "data.csv");
    }


    private static void genCsvFile(Map<String, List<String>> seasonDataMap, String csvPath) throws IOException{
        StringBuilder stringBuilder = new StringBuilder();
        AtomicInteger atomicInteger = new AtomicInteger(0);
        // 所有季度
        for (Map.Entry<String, List<String>> entry : seasonDataMap.entrySet()) {
            // 单季度dataList
            for(String line: entry.getValue()){
                JSONObject jsonObject = JSON.parseObject(line);
                JSONArray jsonArray = jsonObject.getJSONArray("data");
                atomicInteger.addAndGet(jsonArray.size());
                // dataList中的fund
                for (int i = 0; i < jsonArray.size(); i++) {
                    JSONArray item = jsonArray.getJSONArray(i);
                    // fund的字段
                    for (int j = 0; j < item.size(); j++) {
                        String value = item.getString(j);
                        if (StringUtils.isBlank(value)) {
                            value = "0.00";
                        } else {
                            value = value.replace(",", "");
                        }
                        stringBuilder.append(value);
                        if (j < item.size() - 1) {
                            stringBuilder.append(",");
                        } else {
                            stringBuilder.append(",").append(entry.getKey()).append("\r\n");
                        }
                    }
                }
            }

        }
        FileUtils.write(new File(csvPath), stringBuilder, "gbk", false);
        System.out.println(atomicInteger);
    }


    private static List<String> loadData(String t, int pn) {
        String urlApi = "aHR0cDovL2Z1bmQuZWFzdG1vbmV5LmNvbS9kYXRhL0Z1bmREYXRhUG9ydGZvbGlvX0ludGVyZmFjZS5hc3B4P2R0PTgmbWM9cmV0dXJuSnNvbiZzdD1kZXNjJnNjPXFtemZl";
        String urlPage = "aHR0cDovL2Z1bmQuZWFzdG1vbmV5LmNvbS9kYXRhL2dtYmRkZXRhaWwuaHRtbCNkdDg7dDIwMTlfNDtwaTE7cG41MDtzdGRlc2M7c2NxbXpmZQ==";
        urlApi = new String(Base64.getDecoder().decode(urlApi));
        urlPage = new String(Base64.getDecoder().decode(urlPage));
        StringBuilder url = new StringBuilder(urlApi);
        url.append("&t=" + t).append("&pn=" + pn);
        System.out.println("urlPage=" + urlPage);
        System.out.println("urlApi=" + url);
        List<String> result = new ArrayList<>();
        int index = 1;
        int pages = -1;
        int curpage = 1;
        while (pages != curpage) {
            String body = HttpUtils.get(url.toString() + "&pi=" + index++);
            body = body.substring(body.indexOf("=") + 1, body.lastIndexOf(";"));
            result.add(body);
            JSONObject jsonObject = JSON.parseObject(body);
            pages = jsonObject.getIntValue("pages");
            curpage = jsonObject.getIntValue("curpage");
            if (index > 100) {
                throw new RuntimeException("index greater than 100");
            }
            try {
                //
                Thread.sleep(2000);
            } catch (Exception e) {

            }
        }
        return result;


    }

    private static List<String> genRange(String begin, String end) {
        List<String> result = new ArrayList<>();
        while (null != begin) {
            result.add(begin);
            begin = getNext(begin, end);
        }
        return result;
    }

    private static String getNext(String curr, String end) {
        if (curr.compareTo(end) >= 0) {
            return null;
        }
        //
        String[] splitCurr = curr.split("_");
        int currYear = Integer.parseInt(splitCurr[0]);
        int currSeason = Integer.parseInt(splitCurr[1]);
        //
        String[] splitEnd = end.split("_");
        int endYear = Integer.parseInt(splitEnd[0]);
        int endSeason = Integer.parseInt(splitEnd[1]);
        if (currYear < endYear) {
            if (currSeason < 4) {
                currSeason++;
            } else {
                currYear++;
                currSeason = 1;
            }
        } else {
            if (currSeason < endSeason) {
                currSeason++;
            } else {
                currSeason = endSeason;
            }
        }
        return currYear + "_" + currSeason;


    }

}
