package com.df.dataStructure.hash.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 202. 快乐数
 * 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果 可以变为  1，那么这个数就是快乐数。
 *
 * @author hanyli
 * @date 2021/1/27
 */
public class IsHappy {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (true) {
            int sum = getsum(n);
            if (sum == 1) return true;
            if (set.contains(sum)) {
                return false;
            }
            set.add(sum);
            n = sum;
        }
    }

    private int getsum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += (n % 10) * (n % 10);
            n = n / 10;
        }
        return sum;
    }
}
