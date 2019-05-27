package com.zeroq6.java.learn.algorithm.stack;


/**
 * 栈
 * 后进先出，只能在一端进行插入和删除
 * <p>
 * http://blog.51cto.com/ahalei/1377872
 *
 * 解密回文
 */
public class StackTest {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 7, 2, 3};

        Stack<Integer> stack = new Stack<Integer>();
        int mid = arr.length / 2 - 1;// 长度为偶数，取一半，长度为奇数，相当于去掉中间的取一半，然后下标从0开始，所以最后减1
        // 压栈
        for (int i = 0; i <= mid; i++) {
            stack.push(arr[i]);
        }
        // 弹栈
        for (int i = (arr.length % 2 == 0 ? mid + 1 : mid + 2); i < arr.length; i++) {
            if (stack.peek().equals(arr[i])) {
                stack.pop();
            } else {
                break;
            }
        }

        if (stack.isEmpty()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }


    }
}
