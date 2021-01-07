package com.df.dataStructure.string_array;

/**
 * @author hanyli
 * @date 2020/12/24
 */
public class Candy {
    public static int candy(int[] ratings) {
        int length = ratings.length;
        int[] res = new int[length];
        for (int i = 0; i < length; i++) {
            if (i > 0 && ratings[i - 1] < ratings[i]) {
                res[i] = res[i - 1] + 1;
            } else {
                res[i] = 1;
            }
        }
        int count = 0;
        for (int i = length - 1; i >= 0; i--) {
            if (i > 0 && ratings[i] < ratings[i - 1] && res[i] >= res[i - 1]) {
                res[i - 1] = res[i] + 1;
            }
            count += res[i];
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 87, 87, 87, 2, 1};
        candy(arr);
    }
}
