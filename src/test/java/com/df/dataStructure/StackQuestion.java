package com.df.dataStructure;

import javax.sound.midi.Soundbank;
import java.util.Stack;

/**
 * 设计一个栈 有pop push 和获取最小值getMin方法
 * 多一个辅助栈  用于记录最小值
 * 主栈元素出栈时 如果是最小值 辅助栈顶出栈
 * 辅助栈顶为当前栈的最小值
 *
 * @author hanyli
 * @date 2020/9/23
 */
public class StackQuestion {
    private Stack<Integer> mainStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(Integer element) {
        mainStack.push(element);
        //辅助栈为空  或者元素小于等于栈顶元素  进栈
        if (minStack.isEmpty() || element <= minStack.peek()) {
            minStack.push(element);
        }
    }
    public Integer pop() {
        Integer pop = mainStack.pop();
        //如果出栈元素和辅助栈顶元素相等  辅助栈顶出栈
        if (pop.equals(minStack.peek())) {
            minStack.pop();
        }
        return pop;
    }

    public Integer getMin() {
        if (mainStack.isEmpty()) {
            throw new RuntimeException("stack is empty");
        }
        return minStack.peek();
    }

    public static void main(String[] args) {
        StackQuestion stackQuestion = new StackQuestion();
        stackQuestion.push(4);
        stackQuestion.push(5);
        stackQuestion.push(3);
        stackQuestion.push(65);
        stackQuestion.push(1);
        System.out.println(stackQuestion.getMin());
        stackQuestion.pop();
        System.out.println(stackQuestion.getMin());

    }
}
