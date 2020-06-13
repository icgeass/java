package com.zeroq6.java.corejava.pattern;

import org.apache.commons.lang3.time.StopWatch;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @Author: icgeass@hotmail.com
 * @Date: 2020/6/13 18:06
 */
public class PatternTest {

    public static void main(String[] args) throws Exception{
        String input = "123456789012345"; // 123456789012345# will fast
        List<String> patternList = new ArrayList<>();
        patternList.add("\\w#");
        patternList.add("(\\w+)+#");
        patternList.add("((\\w+)+)+#");
        MyStopWatch stopWatch = new MyStopWatch();
        testSpeed(input, patternList.toArray(new String[0]));
        patternList = patternList.stream().map(e -> e.replace("+", "*")).collect(Collectors.toList());
        testSpeed(input, patternList.toArray(new String[0]));

    }

    private static void testSpeed(String input, String... regex){
        MyStopWatch stopWatch = new MyStopWatch();
        for(String item : regex){
            stopWatch.resetAndStart();
            System.out.println(Pattern.matches(item, input));
            System.out.println(stopWatch.getTime());
        }
        System.out.println("-------------------------");
    }

}
