package com.df.dataStructure.stack_queue;

import java.util.Stack;

/**
 * 20. 有效的括号
 * 如果是有效的括号  那么左右括号一定是对应的 而且是镜像的
 * 所以可以利用栈处理
 * 所以遇到左括号放进对应的右括号 遇到右括号并且和栈顶元素相同移除栈顶 否则直接判定false
 * 最后判定栈中是不是还有元素
 *
 * @author hanyli
 * @date 2021/3/5
 */
public class IsValid {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //遇到左括号push相应的右括号
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || stack.peek() != c) {
                //遇到右括号和栈顶元素相比  不相同肯定是不匹配
                return false;
            } else {
                //匹配了移除栈顶元素
                stack.pop();
            }
        }
        //最后栈为空说明括号有效
        return stack.isEmpty();
    }
}
