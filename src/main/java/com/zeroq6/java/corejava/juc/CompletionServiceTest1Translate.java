package com.zeroq6.java.corejava.juc;

import java.util.concurrent.*;

public class CompletionServiceTest1Translate {

    public static void main(String[] args) throws Exception {
        System.out.println("---->" + new CompletionServiceTest1Translate().translate("word"));
        System.out.println("===============================");
        System.out.println("---->" + new CompletionServiceTest1Translate().translate2("word2"));
    }


    public String translate2(String content) throws Exception {

        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final StringBuilder stringBuilder = new StringBuilder();
        new Thread(()-> {
            if(appendResult(stringBuilder, baidu(content))){
                countDownLatch.countDown();
            }

        }).start();
        new Thread(()-> {
            if(appendResult(stringBuilder, youdao(content))){
                countDownLatch.countDown();
            }
        }).start();
        new Thread(()-> {
            if(appendResult(stringBuilder, google(content))){
                countDownLatch.countDown();
            }
        }).start();
        countDownLatch.await();
        return stringBuilder.toString();

    }

    private boolean appendResult(StringBuilder stringBuilder, String result){
        if(null == stringBuilder){
            return false;
        }
        if(stringBuilder.length() == 0){
            synchronized (this){
                if(stringBuilder.length() == 0){
                    stringBuilder.append(result);
                    return true;
                }
            }
        }
        return false;
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
