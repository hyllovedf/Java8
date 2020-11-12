package com.df.dataStructure.string_array;

/**
 * 1432. 改变一个整数能得到的最大差值
 * <p>
 * 给你一个整数 num 。你可以对它进行如下步骤恰好 两次 ：
 * <p>
 * 选择一个数字 x (0 <= x <= 9).
 * 选择另一个数字 y (0 <= y <= 9) 。数字 y 可以等于 x 。
 * 将 num 中所有出现 x 的数位都用 y 替换。
 * 得到的新的整数 不能 有前导 0 ，得到的新整数也 不能 是 0 。
 * 令两次对 num 的操作得到的结果分别为 a 和 b 。
 * <p>
 * 请你返回 a 和 b 的 最大差值 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：num = 555
 * 输出：888
 * 解释：第一次选择 x = 5 且 y = 9 ，并把得到的新数字保存在 a 中。
 * 第二次选择 x = 5 且 y = 1 ，并把得到的新数字保存在 b 中。
 * 现在，我们有 a = 999 和 b = 111 ，最大差值为 888
 *
 * @author hanyli
 * @date 2020/10/9
 */
public class MaxDiff {
    public static int maxDiff(int num) {
        String value = String.valueOf(num);
        int max = getMax(value);
        int min = getMin(value);
        return max - min;
    }

    private static int getMax(String value) {
        char frist = value.charAt(0);
        String r = String.valueOf(frist);
        if (Integer.parseInt(String.valueOf(frist)) == 9) {
            for (int i = 1; i < value.length(); i++) {
                if (value.charAt(i) == frist) {
                    continue;
                }
                r = String.valueOf(value.charAt(i));
                break;
            }
        }
        String s = value.replaceAll(r, "9");
        return Integer.parseInt(s);
    }

    private static int getMin(String value) {
        char frist = value.charAt(0);
        int y = 0;
        String s = String.valueOf(frist);
        if (Integer.parseInt(String.valueOf(frist)) == 1) {
            int i = 1;
            for ( ;i < value.length(); i++) {
                if (frist == value.charAt(i)||value.charAt(i)=='0') {
                    continue;
                }
                s = String.valueOf(value.charAt(i));
                break;
            }
            if (i == value.length()) {
                return Integer.parseInt(value);
            }

        } else {
            y++;
        }

        String s1 = value.replaceAll(s, String.valueOf(y));
        return Integer.parseInt(s1);
    }

    public static void main(String[] args) {
//        int i = maxDiff(1101057);
//        System.out.println(i);
        int g = g();
        System.out.println(g);
    }

    private static int g() {
        int i = 0;
        try {
            i=  k();
        } catch (Exception e) {

        }
        try {
            i = j();
        } catch (Exception ex) {

        }
        return i;
    }

    private static int j() {
        throw new RuntimeException("k");
    }

    private static int k() {
        return 9;
    }

}
