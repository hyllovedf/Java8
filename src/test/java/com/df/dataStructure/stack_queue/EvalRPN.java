package com.df.dataStructure.stack_queue;

import java.util.Stack;

/**
 * @author hanyli
 * @date 2021/3/5
 */
public class EvalRPN {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (String token : tokens) {
            if ("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token)) {
                int res = getRes(stack, token);
                stack.push(String.valueOf(res));
            } else {
                stack.push(token);
            }
        }
        return Integer.parseInt(stack.peek());
    }

    private Integer getRes(Stack<String> stack, String token) {
        String pop2 = stack.pop();
        String pop1 = stack.pop();
        switch (token) {
            case "+":
                return Integer.parseInt(pop1) + Integer.parseInt(pop2);
            case "-":
                return Integer.parseInt(pop1) - Integer.parseInt(pop2);
            case "*":
                return Integer.parseInt(pop1) * Integer.parseInt(pop2);
            case "/":
                return Integer.parseInt(pop1) / Integer.parseInt(pop2);
            default:
                return null;
        }

    }
}
