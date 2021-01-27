package com.df.dataStructure.string_array.LeetCode.array.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * 59. 螺旋矩阵 II
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 * <p>
 * 走一圈包含了四个循环:
 * 1.上行从左到右
 * 2.右列从上到下
 * 3.下行从右到左
 * 4.左列从下到上
 *
 * @author hanyli
 * @date 2021/1/26
 */
public class GenerateMatrix {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        //起始位置
        int startx = 0, starty = 0;
        //需要走的圈数
        int loop = n / 2;
        //偏移量
        int offset = 1;
        //需要填充的值
        int count = 1;
        //n为奇数时中间的位置
        int mid = n / 2;
        int i, j;
        while (loop-- > 0) {
            i = startx;
            j = starty;
            //上行从左到右
            for (; j < starty + n - offset; j++) {
                ans[i][j] = count++;
            }
            //右列从上到下
            for (; i < startx + n - offset; i++) {
                ans[i][j] = count++;
            }
            //下行从右到左
            for (; j > starty; j--) {
                ans[i][j] = count++;
            }
            //左列从下到上
            for (; i > startx; i--) {
                ans[i][j] = count++;
            }
            //起始位置更改
            startx++;
            starty++;
            //因为一圈过后两头都已经填充了  所以偏移量需要+2
            offset += 2;
        }
        //n为奇数时中间的位置需要特殊处理
        if (n % 2 == 1) {
            ans[mid][mid] = count;
        }
        return ans;
    }

    public static void main(String[] args) {
        GenerateMatrix generateMatrix = new GenerateMatrix();
        generateMatrix.generateMatrix(4);
//        int[][] arr = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] arr = new int[][]{{6, 9, 7}};
//        int[][] arr = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        generateMatrix.spiralOrder(arr);
    }

    /**
     * 54. 螺旋矩阵
     * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
     *
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> order = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return order;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int left = 0, right = columns - 1, top = 0, bottom = rows - 1;
        while (left <= right && top <= bottom) {
            for (int column = left; column <= right; column++) {
                order.add(matrix[top][column]);
            }
            for (int row = top + 1; row <= bottom; row++) {
                order.add(matrix[row][right]);
            }
            if (left < right && top < bottom) {
                for (int column = right - 1; column > left; column--) {
                    order.add(matrix[bottom][column]);
                }
                for (int row = bottom; row > top; row--) {
                    order.add(matrix[row][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return order;
    }
}
