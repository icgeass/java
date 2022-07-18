package com.zeroq6.java.stream;


import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class StreamUtils {


    public static <T, K> Map<K, T> toMap(List<T> list, Function<? super T, ? extends K> keyMapper) {
        return toMap(list, keyMapper, Function.identity());
    }


    public static <T, K, U> Map<K, U> toMap(List<T> list, Function<? super T, ? extends K> keyMapper,
                                            Function<? super T, ? extends U> valueMapper) {
        return toMap(list, keyMapper, valueMapper, null);
    }

    public static <T, K, U> Map<K, U> toMap(List<T> list, Function<? super T, ? extends K> keyMapper,
                                            Function<? super T, ? extends U> valueMapper, Predicate<? super T> predicate) {
        if (CollectionUtils.isEmpty(list)) {
            return new HashMap<>();
        }
        return list.stream().filter(Objects::nonNull).filter(e -> null == predicate || predicate.test(e)).collect(Collectors.toMap(keyMapper, valueMapper, (v1, v2) -> v1));
    }

    public static <T, R> List<R> toList(List<T> list, Function<? super T, ? extends R> mapper) {
        return toList(list, mapper, null);
    }

    public static <T, R> List<R> toList(List<T> list, Function<? super T, ? extends R> mapper, Predicate<? super T> predicate) {
        if (CollectionUtils.isEmpty(list)) {
            return new ArrayList<>();
        }
        return list.stream().filter(Objects::nonNull).filter(e -> null == predicate || predicate.test(e)).map(mapper).distinct().collect(Collectors.toList());
    }


    public static <T, K, U> Map<K, U> toMap(Map<K, T> map,
                                            Function<? super T, ? extends U> valueMapper) {

        return toMap(map, Function.identity(), valueMapper);
    }

    public static <T, K, U> Map<K, U> toMap(Map<K, T> map,
                                            Function<? super K, ? extends K> keyMapper,
                                            Function<? super T, ? extends U> valueMapper) {
        if (MapUtils.isEmpty(map)) {
            return new HashMap<>();
        }
        final Map<K, U> resultMap = new HashMap<>();
        map.entrySet().stream().filter(Objects::nonNull)
                .forEach(entry -> {
                    if (null != entry.getKey() && null != entry.getValue() && null != keyMapper && null != valueMapper) {
                        resultMap.put(keyMapper.apply(entry.getKey()), valueMapper.apply(entry.getValue()));
                    }
                });
        return resultMap;
    }


    public static <T, K> Map<K, List<T>> groupingBy(List<T> list,
                                                    Function<? super T, ? extends K> keyMapper) {
        if (CollectionUtils.isEmpty(list)) {
            return new HashMap<>();
        }
        return list.stream().filter(Objects::nonNull).distinct().collect(Collectors.groupingBy(keyMapper));
    }
}