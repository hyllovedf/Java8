package com.df.dataStructure.string_array.LeetCode.string.easy;

/**
 * 剑指 Offer 05. 替换空格
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 * @author hanyli
 * @date 2021/1/28
 */
public class ReplaceSpace {
    public String replaceSpace(String s) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                builder.append("%20");
            } else {
                builder.append(c);
            }
        }
        return builder.toString();
    }

    /**
     * 双指针
     * 使用数组重新填充
     * @param s
     * @return
     */
    public String replaceSpace2(String s) {
        //统计空格的个数
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                count++;
            }
        }
        //创建一个数组
        char[] arr = new char[2 * count + s.length()];
        //i表示字符串的指针  j表示数组的指针
        for (int i = s.length() - 1, j = arr.length - 1; i >= 0 && i <= j; i--, j--) {
            char c = s.charAt(i);
            if (c != ' ') {
                arr[j] = c;
            } else {
                arr[j] = '0';
                arr[--j] = '2';
                arr[--j] = '%';
            }
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        ReplaceSpace replaceSpace = new ReplaceSpace();
        replaceSpace.replaceSpace2("We are happy.");
    }
}
