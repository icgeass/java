package com.zeroq6.java.corejava.juc;

import java.util.concurrent.*;

public class CompletionServiceTest1Translate {

    public static void main(String[] args) throws Exception {
        System.out.println("---->" + new CompletionServiceTest1Translate().translate("word"));
    }


    // todo
    public String translate(String content) throws Exception {

        ExecutorService executorService = JucUtils.newFixedThreadPool(3);
        CompletionService<String> completionService = new ExecutorCompletionService(executorService);
        completionService.submit(() -> baidu(content));
        completionService.submit(() -> youdao(content));
        completionService.submit(() -> google(content));
        String re = completionService.take().get();
        executorService.shutdown();
        return re;
    }

    public String baidu(String content) {
        JucUtils.randomSleep();
        String re = "baidu " + content;
        System.out.println(re);
        return re;
    }

    public String google(String content) {
        JucUtils.randomSleep();
        String re = "google " + content;
        System.out.println(re);
        return re;
    }

    public String youdao(String content) {
        JucUtils.randomSleep();
        String re = "youdao " + content;
        System.out.println(re);
        return re;
    }


}
