package com.zeroq6.java.leetcode.tag.stack;


/**
 * 以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。
 * <p>
 * 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成部分。更多信息请参阅：Linux / Unix中的绝对路径 vs 相对路径
 * <p>
 * 请注意，返回的规范路径必须始终以斜杠 / 开头，并且两个目录名之间必须只有一个斜杠 /。最后一个目录名（如果存在）不能以 / 结尾。此外，规范路径必须是表示绝对路径的最短字符串。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入："/home/"
 * 输出："/home"
 * 解释：注意，最后一个目录名后面没有斜杠。
 * 示例 2：
 * <p>
 * 输入："/../"
 * 输出："/"
 * 解释：从根目录向上一级是不可行的，因为根是你可以到达的最高级。
 * 示例 3：
 * <p>
 * 输入："/home//foo/"
 * 输出："/home/foo"
 * 解释：在规范路径中，多个连续斜杠需要用一个斜杠替换。
 * 示例 4：
 * <p>
 * 输入："/a/./b/../../c/"
 * 输出："/c"
 * 示例 5：
 * <p>
 * 输入："/a/../../b/../c//.//"
 * 输出："/c"
 * 示例 6：
 * <p>
 * 输入："/a//b////c/d//././/.."
 * 输出："/a/b/c"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/simplify-path
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution71 {

    public String simplifyPath(String path) {
        if (path.charAt(path.length() - 1) != '/') {
            path = path + "/"; // 用于当出现/..或者/.结尾时能够兼容处理
        }
        StringBuilder stringBuilder = new StringBuilder(path.charAt(0) + "");


        for (int i = 1; i < path.length(); i++) {
            char ch = path.charAt(i);
            int len = stringBuilder.length();
            if (ch == '/') {
                // 去掉//
                if (stringBuilder.charAt(len - 1) == '/') {
                    continue;
                }
                // 去掉当前路径
                if (len >= 2 && stringBuilder.charAt(len - 1) == '.' && stringBuilder.charAt(len - 2) == '/') {
                    stringBuilder.deleteCharAt(len - 1);
                    continue;
                }
                // 去掉父路径
                if (len >= 3 && stringBuilder.charAt(len - 1) == '.' && stringBuilder.charAt(len - 2) == '.' && stringBuilder.charAt(len - 3) == '/') {
                    if (len == 3) {
                        stringBuilder.delete(len - 2, len);
                    } else {
                        stringBuilder.delete(len - 3, len);
                        int lastIndexOfSlash = stringBuilder.lastIndexOf("/"); // 要保证先过滤//，否则删除父目录时可能index错误
                        stringBuilder.delete(lastIndexOfSlash + 1, stringBuilder.length());
                    }
                    continue;
                }
                // 删除最后一个/，需要放到最后，否则当以./或者../结尾会无法删除当前目录和父目录
                if (i == path.length() - 1) {
                    continue;
                }
            }
            stringBuilder.append(ch);

        }
        // 处理由于移除父目录，而后面没有出现新目录而末尾出现的/，比如/a/b/../---->/a/
        int stringBuilderLength = stringBuilder.length();
        if (stringBuilderLength > 1 && stringBuilder.charAt(stringBuilderLength - 1) == '/') {
            stringBuilder.delete(stringBuilderLength - 1, stringBuilderLength);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {

        System.out.println(new Solution71().simplifyPath("/home/"));
        System.out.println(new Solution71().simplifyPath("/../"));
        System.out.println(new Solution71().simplifyPath("/home//foo/"));
        System.out.println(new Solution71().simplifyPath("/a/./b/../../c/"));
        System.out.println(new Solution71().simplifyPath("/a/../../b/../c//.//"));
        System.out.println(new Solution71().simplifyPath("/a//b////c/d//././/.."));
        System.out.println(new Solution71().simplifyPath("/."));

    }
}
