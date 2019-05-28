package com.zeroq6.java.data_structure.quene;


/**
 * 队列，只允许队头删除，队尾结束
 * <p>
 * http://blog.51cto.com/ahalei/1371613
 *
 * 新学期开始了，小哈是小哼的新同桌（小哈是个小美女哦~），
 * 小哼向小哈询问QQ号，小哈当然不会直接告诉小哼啦，原因嘛你懂的。
 * 所以小哈给了小哼一串加密过的数字，同时小哈也告诉了小哼解密规则。
 * 规则是这样的：首先将第1个数删除，紧接着将第2个数放到这串数的末尾，
 * 再将第3个数删除并将第4个数再放到这串数的末尾，再将第5个数删除……直到剩下最后一个数，
 * 将最后一个数也删除。按照刚才删除的顺序，把这些删除的数连在一起就是小哈的QQ啦。
 * 现在你来帮帮小哼吧。小哈给小哼加密过的一串数是“6 3 1 75 8 9 2 4”。
 *
 * OK，现在轮到你动手的时候了。快去找出9张便签或小纸片，
 * 将“6 3 1 75 8 9 2 4”这9个数分别写在9张便签上，模拟一下解密过程。
 * 如果你没有理解错解密规则的话，解密后小哈的QQ号应该是“6 1 5 94 7 2 8 3”。
 */
public class QueueTest {

    public static void main(String[] args) {

        int[] arr = new int[]{6, 3, 1, 7, 5, 8, 9, 2, 4};

        Queue<Integer> queue = new Queue<Integer>(16);
        // 初始化队列
        for (int i = 0; i < arr.length; i++) {
            queue.addLast(arr[i]);
        }

        while (!queue.isEmpty()) {
            // 删除第一个数并打印
            Integer item = queue.removeFirst();
            System.out.print(item + " ");
            if (!queue.isEmpty()) {
                // 删除下一个并移到末尾
                item = queue.removeFirst();
                queue.addLast(item);
            }
        }


    }
}
