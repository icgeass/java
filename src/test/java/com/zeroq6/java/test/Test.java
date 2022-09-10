package com.zeroq6.java.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.zeroq6.java.stream.StreamUtils;

import java.util.List;
import java.util.function.Function;

public class Test {

    @org.junit.Test
    public void test() {
        List<UserDO> userDOList = UserDO.randomUser(1);
        System.out.println(JSON.toJSONString(StreamUtils.groupingBy(userDOList, UserDO::getId, Function.identity()), SerializerFeature.PrettyFormat));
        System.out.println(JSON.toJSONString(StreamUtils.groupingBy(userDOList, UserDO::getId, UserDO::getName), SerializerFeature.PrettyFormat));
    }
}
