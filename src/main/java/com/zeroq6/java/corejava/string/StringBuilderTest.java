package com.zeroq6.java.corejava.string;

/**
 * @author
 * @date 2018/7/26
 *
 * https://blog.csdn.net/zengshunyao/article/details/40023577
 */
public class StringBuilderTest {
    public static void main(String[] args) throws Exception {
        compare();
        capacity();


    }


    /**
     * 扩容
     * @throws Exception
     */
    public static void capacity() throws Exception{
        // super(str.length() + 16);
        StringBuilder stringBuilder = new StringBuilder("123"); // 3 + 16
        System.out.println("初始容量: " + stringBuilder.capacity());

        stringBuilder.ensureCapacity(20);
        // int newCapacity = (value.length << 1) + 2
        System.out.println("扩容容量: " + stringBuilder.capacity());  // 40 = (3+16)*2+2

    }


    /**
     * string性能
     *
     * 常量无影响
     * @throws Exception
     */
    public static void compare() throws Exception{
        int stringCount = 10000;
        int stringBufferCount = stringCount * 10;
        int stringBuilderCount = stringBufferCount;
        String string = "";
        StringBuffer stringBuffer = new StringBuffer("");
        StringBuilder stringBuilder = new StringBuilder("");

        // String
        long begin = System.currentTimeMillis();
        for (int i = 0; i < stringCount; i++) {
            string += i;
        }
        System.out.println("String: " + (System.currentTimeMillis() - begin));

        // StringBuffer
        begin = System.currentTimeMillis();
        for (int i = 0; i < stringBufferCount; i++) {
            stringBuffer.append(i);
        }
        System.out.println("StringBuffer: " + (System.currentTimeMillis() - begin));

        // StringBuilder
        begin = System.currentTimeMillis();
        for (int i = 0; i < stringBuilderCount; i++) {
            stringBuilder.append(i);
        }
        System.out.println("StringBuilder: " + (System.currentTimeMillis() - begin));


        // toString cache  性能
        int toStringCount = 1000;
        begin = System.currentTimeMillis();
        for (int i = 0; i < toStringCount; i++) {
            stringBuffer.toString();
        }
        System.out.println("StringBuffer toString(): " + (System.currentTimeMillis() - begin));

        begin = System.currentTimeMillis();
        for (int i = 0; i < toStringCount; i++) {
            stringBuilder.toString();
        }
        System.out.println("StringBuilder toString(): " + (System.currentTimeMillis() - begin));

    }


}
