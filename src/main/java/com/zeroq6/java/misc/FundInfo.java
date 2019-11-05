package com.zeroq6.java.misc;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;


public class FundInfo {


    public static void main(String[] args) throws IOException, URISyntaxException {
        File dataFile = new File(FundInfo.class.getClassLoader().getResource("misc/data.txt").getFile());
        List<String> list = FileUtils.readLines(dataFile, "utf-8");
        StringBuilder stringBuilder = new StringBuilder();
        for (String line : list) {
            JSONObject jsonObject = JSON.parseObject(line);
            JSONArray jsonArray = jsonObject.getJSONArray("data");
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
    }

}
