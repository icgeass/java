package com.zeroq6.java.leetcode.solution;


import com.alibaba.fastjson.JSON;

/**
 * https://leetcode-cn.com/problems/valid-sudoku/
 * <p>
 * <p>
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * <p>
 * <p>
 * 上图是一个部分填充的有效的数独。
 * <p>
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 * ["5","3",".",".","7",".",".",".","."],
 * ["6",".",".","1","9","5",".",".","."],
 * [".","9","8",".",".",".",".","6","."],
 * ["8",".",".",".","6",".",".",".","3"],
 * ["4",".",".","8",".","3",".",".","1"],
 * ["7",".",".",".","2",".",".",".","6"],
 * [".","6",".",".",".",".","2","8","."],
 * [".",".",".","4","1","9",".",".","5"],
 * [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:
 * [
 * ["8","3",".",".","7",".",".",".","."],
 * ["6",".",".","1","9","5",".",".","."],
 * [".","9","8",".",".",".",".","6","."],
 * ["8",".",".",".","6",".",".",".","3"],
 * ["4",".",".","8",".","3",".",".","1"],
 * ["7",".",".",".","2",".",".",".","6"],
 * [".","6",".",".",".",".","2","8","."],
 * [".",".",".","4","1","9",".",".","5"],
 * [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: false
 * 解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
 * 但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
 * 说明:
 * <p>
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 给定数独序列只包含数字 1-9 和字符 '.' 。
 * 给定数独永远是 9x9 形式的。
 *
 * 第一次错误：
 *
 * filling[pos] = pos; // 否则占用该位置
 * 应为
 * filling[pos] = tmp; // 否则占用该位置
 *
 */
public class Solution36 {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            // 校验第i行
            if (!validate(board[i][0], board[i][1], board[i][2], board[i][3], board[i][4], board[i][5], board[i][6], board[i][7], board[i][8])) {
                return false;
            }
            // 校验第i列
            if (!validate(board[0][i], board[1][i], board[2][i], board[3][i], board[4][i], board[5][i], board[6][i], board[7][i], board[8][i])) {
                return false;
            }
            // 找到实线小框中9个数字的左上角
            // 0,3,6
            // 行
            if (i % 3 == 0) {
                // 列
                for (int j = 0; j < 3; j++) {
                    int add = j * 3;
                    if (!validate(board[i][0 + add], board[i][1 + add], board[i][2 + add], board[i + 1][0 + add], board[i + 1][1 + add], board[i + 1][2 + add], board[i + 2][0 + add], board[i + 2][1 + add], board[i + 2][2 + add])) {
                        return false;
                    }
                }


            }
        }
        return true;
    }

    private boolean validate(char... chars) {
        int[] filling = new int[9];
        char tmp;
        int pos;
        for (int i = 0; i < chars.length; i++) {
            tmp = chars[i];
            if (tmp == '.') {
                continue;
            }
            pos = tmp - '0' - 1;
            if (filling[pos] != 0) { // 如果该位置被占用，说明重复了
                return false;
            } else {
                filling[pos] = tmp; // 否则占用该位置
            }

        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println((int) '0');
        System.out.println((int) '9');
        System.out.println(JSON.toJSONString(new int[5]));

//        char[] chars0 = new char[]{'5', '3', '.', '.', '7', '.', '.', '.', '.'};
//        char[] chars1 = new char[]{'6', '.', '.', '1', '9', '5', '.', '.', '.'};
//        char[] chars2 = new char[]{'.', '9', '8', '.', '.', '.', '.', '6', '.'};
//        char[] chars3 = new char[]{'8', '.', '.', '.', '6', '.', '.', '.', '3'};
//        char[] chars4 = new char[]{'4', '.', '.', '8', '.', '3', '.', '.', '1'};
//        char[] chars5 = new char[]{'7', '.', '.', '.', '2', '.', '.', '.', '6'};
//        char[] chars6 = new char[]{'.', '6', '.', '.', '.', '.', '2', '8', '.'};
//        char[] chars7 = new char[]{'.', '.', '.', '4', '1', '9', '.', '.', '5'};
//        char[] chars8 = new char[]{'.', '.', '.', '.', '8', '.', '.', '7', '9'};


        char[] chars0 = new char[]{'.','.','.','.','.','.','.','.','.'};
        char[] chars1 = new char[]{'.','.','.','3','.','.','5','.','.'};
        char[] chars2 = new char[]{'.','.','.','.','.','.','.','.','.'};
        char[] chars3 = new char[]{'.','.','.','8','.','.','.','.','.'};
        char[] chars4 = new char[]{'.','.','.','.','1','1','6','.','.'};
        char[] chars5 = new char[]{'.','.','.','.','.','.','.','.','.'};
        char[] chars6 = new char[]{'.','.','.','.','.','.','1','.','.'};
        char[] chars7 = new char[]{'.','.','.','.','.','.','.','.','7'};
        char[] chars8 = new char[]{'.','.','.','.','.','.','.','4','.'};

        System.out.println(new Solution36().isValidSudoku(new char[][]{chars0, chars1, chars2, chars3, chars4, chars5, chars6, chars7, chars8}));


    }
}

