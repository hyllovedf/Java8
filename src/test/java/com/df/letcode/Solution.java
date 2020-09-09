package com.df.letcode;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author hanyli
 * @date 2020/6/18
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Solution {

    /**
     * 我们把符合下列属性的数组 A 称作山脉：
     * <p>
     * A.length >= 3
     * 存在 0 < i < A.length - 1 使得A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
     * 给定一个确定为山脉的数组，返回任何满足 A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1] 的 i 的值。
     * <p>
     * 示例 ：
     * <p>
     * 输入：[0,2,1,0]
     * 输出：1
     */
    @Test
    public void peakIndexInMountainArray() {
        int[] A = {0, 2, 1, 0};
        int i = peakIndexInMountainArray(A);
        System.out.println(i);
    }

    private int peakIndexInMountainArray(int[] A) {
        if (A.length < 3) {
            return -1;
        }
        for (int i = 1; i < A.length - 1; i++) {
            if (A[i - 1] < A[i] && A[i] > A[i + 1]) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。
     * <p>
     * <p>
     * <p>
     * 示例 1:
     * <p>
     * 输入: amount = 5, coins = [1, 2, 5]
     * 输出: 4
     * 解释: 有四种方式可以凑成总金额:
     * 5=5
     * 5=2+2+1
     * 5=2+1+1+1
     * 5=1+1+1+1+1
     */
    @Test
    public void change() {
        int[] A = {1, 2, 5};
        int change = change(5, A);
        System.out.println(change);
    }

    public int change(int amount, int[] coins) {
        int count = 0;
        for (int coin : coins) {
            if (amount % coin == 0) {
                count++;
            } else if (amount / coin > 0) {
                change(amount % coin, coins);
            }
        }
        return count;
    }

    @Test
    public void smallestGoodBase() {
        String s = "470988884881403701";
        String s1 = smallestGoodBase(s);
        System.out.println(s1);
    }

    public String smallestGoodBase(String n) {
        boolean matches = n.matches("[0-9]*");
        if (!matches) {
            return "不是数字";
        }
        long integer = Long.parseLong(n);
        int k = 2;
        while (change(integer,k)<0) {
            k++;
        }
        return k + "";
    }

    private int change(long n, int k) {
        if (n % k != 1) {
            return -1;
        }
        if (n / k == 0) {
            return k;
        }else  {
            return change(n / k, k);
        }

    }
}
