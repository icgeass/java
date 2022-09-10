package com.zeroq6.java.test;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.RandomUtils;

import java.io.Serializable;
import java.util.List;

@Data
@Accessors(chain = true)
public class UserDO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private Integer age;

    public static UserDO randomUser(){
        return new UserDO()
                .setId(RandomUtils.nextLong(0, 10000))
                .setAge(RandomUtils.nextInt(1, 60))
                .setName(getRandomChar() + "");
    }

    public static List<UserDO> randomUser(int size){
        List<UserDO> userDOList = Lists.newArrayList();
        for (int i = 0; i < size; i++) {
            userDOList.add(randomUser());
        }
        return userDOList;
    }

    private static char getRandomChar() {
        return (char) (0x4e00 + (int) (Math.random() * (0x9fa5 - 0x4e00 + 1)));
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
