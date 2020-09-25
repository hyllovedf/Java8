package com.df.dataStructure;

import java.util.Stack;

/**
 * 使用栈模拟队列
 * @author hanyli
 * @date 2020/9/25
 */
public class StackToQueue {
    private Stack<Integer> pushStack = new Stack<>();
    private Stack<Integer> popStack = new Stack<>();

    /** Push element x to the back of queue. */
    public void push(int x) {
        pushStack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        trans();
        return popStack.pop();
    }

    /** Get the front element. */
    public int peek() {
        trans();
        return popStack.peek();
    }

    private void trans() {
        if (popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                Integer pop = pushStack.pop();
                popStack.push(pop);
            }
        }
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return popStack.isEmpty() && pushStack.isEmpty();
    }

    public static void main(String[] args) {
        StackToQueue stackToQueue = new StackToQueue();
        stackToQueue.push(1);
        stackToQueue.push(2);
        stackToQueue.push(3);
        stackToQueue.pop();
        stackToQueue.push(4);
        while (!stackToQueue.empty()) {
            int pop = stackToQueue.pop();
            System.out.println(pop);
        }
    }
}
