package com.df.dataStructure.string_array.LeetCode.string.middle;

/**
 * 1208. 尽可能使字符串相等
 * 给你两个长度相同的字符串，s 和 t。
 * 将 s 中的第 i 个字符变到 t 中的第 i 个字符需要 |s[i] - t[i]| 的开销（开销可能为 0），
 * ASCII 码值的差的绝对值。
 * 用于变更字符串的最大预算是 maxCost。在转化字符串时，总开销应当小于等于该预算，
 * 这也意味着字符串的转化可能是不完全的。
 * 如果你可以将 s 的子字符串转化为它在 t 中对应的子字符串，则返回可以转化的最大长度。
 * 如果 s 中没有子字符串可以转化成 t 中对应的子字符串，则返回 0。
 *
 * @author hanyli
 * @date 2021/1/22
 */
public class EqualSubstring {
    public int equalSubstring(String s, String t, int maxCost) {
        int left = 0, right = 0, cost = 0, len = 0;
        while (right < s.length()) {
            char rc = s.charAt(right);
            char tc = t.charAt(right);
            cost += Math.abs(rc - tc);
            //注意使用循环保证cost<maxCost
            while (cost > maxCost) {
                len = Math.max(len, right - left);
                char lc = s.charAt(left);
                cost -= Math.abs(lc - t.charAt(left));
                left++;
            }
            right++;

        }
        //需要考虑最后cost没有超过最大值情况
        return Math.max(len, right - left);
    }

    public static void main(String[] args) {
        EqualSubstring equalSubstring = new EqualSubstring();
        equalSubstring.equalSubstring("krpgjbjjznpzdfy","nxargkbydxmsgby",14);
    }
}
