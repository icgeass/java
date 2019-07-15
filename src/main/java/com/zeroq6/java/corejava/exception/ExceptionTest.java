package com.zeroq6.java.corejava.exception;

import java.io.IOException;

public class ExceptionTest {

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        new Arcane3().f();

    }

    /**
     * 每一个接口都限制了方法 f 可以抛出的被检查异常集合。
     * 一个方法可以抛出的被检查异常集合是它所适用的所有类型声明要抛出的被检查异常集合的交集,而不是合集。
     * 因此,静态类型为 Type3 的对象上的 f 方法根本就不能抛出任何被检查异常。
     * 因此,Arcane3可以毫无错误地通过编译,并且打印 Hello world。
     */
    static class Arcane3 implements Type3 {

        public void f() {
            System.out.println("Hello world");
        }
    }


    interface Type1 {
        void f() throws CloneNotSupportedException;
    }

    interface Type2 {
        void f() throws InterruptedException;
    }

    interface Type3 extends Type1, Type2 {
    }


    /**
     * 被检查异常的一个基本原则。它看起来应该是可以编译的:try 子句执行 I/O,并且 catch 子句捕获 IOException 异常。
     * 但是这个程序不能编译,因为 println 方法没有声明会抛出任何被检查异常,而IOException 却正是一个被检查异常。
     * 语言规范中描述道:
     * 如果一个 catch 子句要捕获一个类型为 E 的被检查异常, 而其相对应的 try 子句不能抛出 E 的某种子类型的异常,那么这就是一个编译期错误。
     */
    private static void test3() {
//        try {
            System.out.println("Hello world");
//        } catch(IOException e) {
//            System.out.println("I've never seen println fail!");
//        }
    }

    /**
     * 当 try 语句块和 finally 语句块都意外结束时,
     * try 语句块中引发意外结束的原因将被丢弃,
     * 而整个 try-finally 语句意外结束的原因将于 finally 语句块意外结束的原因相同
     */
    private static void test2() {
        System.out.println(decision());
    }

    private static boolean decision() {
        try {
            return true;
        } finally {
            return false;
        }
    }

    /**
     * 异常使用
     */
    private static void test1() {

        try {
            int i = 10 / 0;
            System.out.println("i=" + i);
        } catch (ArithmeticException e) {
            System.out.println("Caught Exception");
            System.out.println("e.getMessage(): " + e.getMessage());
            System.out.println("e.toString(): " + e.toString());
            System.out.println("e.printStackTrace():");
            e.printStackTrace();
        } finally {
            System.out.println("run finally");
        }
    }

}
