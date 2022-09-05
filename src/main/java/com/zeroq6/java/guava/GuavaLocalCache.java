package com.zeroq6.java.guava;


import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.jetbrains.annotations.NotNull;

import java.util.Date;
import java.util.concurrent.*;
import java.util.function.Supplier;

// 核心逻辑在LocalCache里面
public class GuavaLocalCache {

    private static final String KEY = "KEY";

    private static final String ERROR = "ERROR";

    // LocalCache.LocalManualCache -> Cache
    private static final Cache<String, String> CACHE1 = CacheBuilder.newBuilder().expireAfterWrite(2, TimeUnit.SECONDS).build();

    // LocalCache.LocalLoadingCache -> LoadingCache -> Cache
    private static final LoadingCache<String, String> CACHE2 = CacheBuilder.newBuilder().refreshAfterWrite(2, TimeUnit.SECONDS).build(new CacheLoader<String, String>() {
        @NotNull
        @Override
        public String load(@NotNull String key) throws Exception {
            log("CACHE2 load begin");
            String result = get(key).call();
            log("CACHE2 load end");
            return result;
        }
    });

    private static final ListeningExecutorService LISTENING_EXECUTOR_SERVICE = MoreExecutors.listeningDecorator(new ThreadPoolExecutor(20, 50,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(100)));

    private static final LoadingCache<String, String> CACHE3 = CacheBuilder.newBuilder()
            .refreshAfterWrite(2, TimeUnit.SECONDS).build(new CacheLoader<String, String>() {
                @NotNull
                @Override
                public String load(@NotNull String key) throws Exception {
                    log("CACHE3 load begin");
                    String result = get(key).call();
                    log("CACHE3 load end");
                    return result;
                }

                @NotNull
                @Override
                public ListenableFuture<String> reload(@NotNull String key, @NotNull String oldValue) {
                    log("CACHE3 reload begin");
                    ListenableFuture<String> listenableFuture = LISTENING_EXECUTOR_SERVICE.submit(get(key));
                    log("CACHE3 reload end");
                    return listenableFuture;
                }
            });


    public static void main(String[] args) throws Exception {
        Supplier<String> supplier1 = () -> {
            try {
                return CACHE1.get(KEY, () -> get(KEY).call());
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            return ERROR;
        };

        Supplier<String> supplier2 = () -> {
            try {
                return CACHE2.get(KEY);
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            return ERROR;
        };

        Supplier<String> supplier3 = () -> {
            try {
                return CACHE3.get(KEY);
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            return ERROR;
        };

        // 预热
        // CACHE3.getAll(Lists.newArrayList(KEY));
        testSpeed(supplier3, 100);
        LISTENING_EXECUTOR_SERVICE.shutdown();
        LISTENING_EXECUTOR_SERVICE.awaitTermination(10, TimeUnit.SECONDS);
    }


    private static Callable<String> get(String key) {
        return () -> {
            log("queryFromDB begin");
            sleep(3000L);
            String result = key + ":data_in_db_" + RandomUtils.nextInt(0, 10000);
            log("queryFromDB end");
            return result;
        };
    }

    private static void testSpeed(Supplier<String> resultSupplier, int threadNums) {
        for (int i = 0; i < threadNums; i++) {
            new Thread(() -> {
                try {
                    log("start get");
                    log(resultSupplier.get());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
            sleep(100L);
        }
    }

    private static void log(Object text) {
        System.out.println(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss.SSS") + "-" + Thread.currentThread().getName() + "-" + text);
    }

    private static void sleep(long millis) {
        try {
            TimeUnit.MILLISECONDS.sleep(millis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
