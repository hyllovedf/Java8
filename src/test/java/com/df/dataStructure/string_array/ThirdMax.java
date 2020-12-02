package com.df.dataStructure.string_array;

import java.util.Stack;

/**
 * 414. 第三大的数
 * @author hanyli
 * @date 2020/11/25
 */
public class ThirdMax {
    public static int thirdMax(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> temp = new Stack<>();
        for (int num : nums) {
            while (true) {
                if (stack.isEmpty()) {
                    stack.push(num);
                    while (!temp.isEmpty()) {
                        stack.push(temp.pop());
                    }
                    break;
                } else {
                    Integer peek = stack.peek();
                    if (num < peek) {
                        stack.push(num);
                        while (!temp.isEmpty()) {
                            stack.push(temp.pop());
                        }
                        break;
                    } else if (num > peek) {
                        temp.push(stack.pop());
                    } else {
                        while (!temp.isEmpty()) {
                            stack.push(temp.pop());
                        }
                        break;
                    }
                }

            }
        }
        Integer pop=null;
        if (stack.size() < 3) {
            while (!stack.isEmpty()) {
                pop = stack.pop();
            }
        } else {
            int count = stack.size() - 3;
            for (int i = 0; i <= count; i++) {
                pop = stack.pop();
            }
        }

        return pop;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,2,5,3,5};
        int i = thirdMax(arr);
        System.out.println(i);
    }
}
