package com.zeroq6.java.corejava.pattern;

import org.apache.commons.lang3.time.StopWatch;

/**
 * @Author: icgeass@hotmail.com
 * @Date: 2020/6/13 18:14
 *
 * https://stackoverflow.com/questions/180158/how-do-i-time-a-methods-execution-in-java
 */
public class MyStopWatch extends StopWatch {
    public void resetAndStart(){
        super.reset();
        super.start();
    }
}
