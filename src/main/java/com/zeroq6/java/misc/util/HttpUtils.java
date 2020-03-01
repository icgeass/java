package com.zeroq6.java.misc.util;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class HttpUtils {

    static OkHttpClient client = new OkHttpClient();

    public static String get(String url)  {

        Request request = new Request.Builder()
                .url(url)
                .build();
        try (Response
                     response = client.newCall(request).execute()) {
            return response.body().string();
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
