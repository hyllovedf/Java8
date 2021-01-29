package com.df.dataStructure.string_array.LeetCode.string.middle;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 151. 翻转字符串里的单词
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * <p>
 * 说明：
 * <p>
 * 无空格字符构成一个 单词 。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 * @author hanyli
 * @date 2021/1/28
 */
public class ReverseWords {
    /**
     * 直接使用强大的api
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        List<String> list = Arrays.asList(s.trim().split("\\s+"));
        Collections.reverse(list);
        return String.join(" ", list);
    }

    /**
     * 底层逻辑实现
     * 分为三步:
     * 1.去除空格
     * 2.反转所有
     * 3.反转单词
     * @param s
     * @return
     */
    public String reverseWords2(String s) {
        //" the  sky is blue "
        char[] chars = s.toCharArray();
        int slow = 0, fast = 0;
        //1.去除空格  "the sky is blue"
        //移除前面的空格
        while (s.length() > 0 && fast < s.length() && chars[fast] == ' ') {
            fast++;
        }
        //移除中间多余的空格
        for (; fast < s.length(); fast++) {
            if (!(fast > 0 && chars[fast - 1] == chars[fast] && chars[fast] == ' ')) {
                chars[slow++] = chars[fast];
            }
        }
        //移除末尾空格
        if (slow - 1 > 0 && chars[slow - 1] == ' ') {
            slow -= 2;
        } else {
            slow--;
        }
        //2.反转所有 反转字符串  "eulb si yks eht"
        reverse(chars, 0, slow);

        int start, end;
        //3.反转单词 "Blue is sky the"
        for (int i = 0; i <= slow; i++) {
            start = i;
            //以空格为界限是一个单词
            while (i <= slow && chars[i] != ' ') {
                i++;
            }
            end = i - 1;
            reverse(chars, start, end);
        }
        char[] chars1 = Arrays.copyOfRange(chars, 0, slow + 1);
        return new String(chars1);
    }

    /**
     * 反转指定区间元素  左闭右闭
     * @param chars
     * @param start
     * @param end
     */
    private void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start++] = chars[end];
            chars[end--] = temp;
        }
    }

    public static void main(String[] args) {
        ReverseWords reverseWords = new ReverseWords();
        reverseWords.reverseWords2("  hello world  ");
    }
}
