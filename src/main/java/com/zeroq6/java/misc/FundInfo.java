package com.zeroq6.java.misc;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zeroq6.java.misc.util.HttpUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * http://fund.eastmoney.com/data/gmbddetail.html#dt8;t2019_4;pi1;pn50;stdesc;scqmzfe
 * http://fund.eastmoney.com/data/FundDataPortfolio_Interface.aspx?dt=8&t=2019_4&pn=1000&mc=returnJson&st=desc&sc=qmzfe
 */

public class FundInfo {


    public static void main(String[] args) throws IOException, URISyntaxException {
        File dataFile = new File(FundInfo.class.getClassLoader().getResource("misc/data.txt").getFile());

        List<String> list = loadData(dataFile, "2019_4", 500);
        StringBuilder stringBuilder = new StringBuilder();
        AtomicInteger atomicInteger = new AtomicInteger(0);
        for (String line : list) {
            JSONObject jsonObject = JSON.parseObject(line);
            JSONArray jsonArray = jsonObject.getJSONArray("data");
            atomicInteger.addAndGet(jsonArray.size());
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONArray item = jsonArray.getJSONArray(i);
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
                        stringBuilder.append("\r\n");
                    }
                }
            }

        }
        FileUtils.write(new File(dataFile.getParent() + File.separator + "data.csv"), stringBuilder, "gbk", false);
        System.out.println(stringBuilder);
        System.out.println(atomicInteger);
    }


    private static List<String> loadData(File writeToFile, String t, int pn) {
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
                Thread.sleep(500);
            } catch (Exception e) {

            }
        }
        if (writeToFile != null) {
            try {
                FileUtils.writeLines(writeToFile, "utf-8", result, false);
                System.out.println(writeToFile.getCanonicalPath());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return result;


    }

}
