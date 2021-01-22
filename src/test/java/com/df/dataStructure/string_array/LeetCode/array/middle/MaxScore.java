package com.df.dataStructure.string_array.LeetCode.array.middle;

/**
 * 1423. 可获得的最大点数
 *
 * @author hanyli
 * @date 2021/1/22
 */
public class MaxScore {
    /**
     * 枚举出所有可能  取最大的
     * 在k的范围内  左端取的数量+右端取的数量=K
     * 从全部从左端取数开始 左端数量依次减少  右端数量依次增加直到右端数量是k
     *
     * 优化的点就是第一轮计算完毕后  后面的结果只需要加加减减就可以得出当前情况的数字和
     * @param cardPoints
     * @param k
     * @return
     */
    public int maxScore(int[] cardPoints, int k) {
        int length = cardPoints.length;
        int len1 = k;
        int right1 = 0;
        int left2 = length - 1;
        int count = 0;
        int countMax = 0;
        while (len1 >= 0) {
            if (len1 == k) {
                //第一次计算所有值
                while (right1 < len1) {
                    count += cardPoints[right1++];
                }
                while (length - left2 <= k - len1) {
                    count += cardPoints[left2--];
                }
            } else {
                //再次计算只需要加加减减
                count -= cardPoints[len1];
                count += cardPoints[length - (k - len1)];
            }

            countMax = Math.max(countMax, count);
            len1--;
        }
        return countMax;
    }

    public static void main(String[] args) {
        MaxScore maxScore = new MaxScore();
        int[] arr = {1, 2, 3, 4, 5, 6, 1};

        maxScore.maxScore(arr, 3);
    }
}
