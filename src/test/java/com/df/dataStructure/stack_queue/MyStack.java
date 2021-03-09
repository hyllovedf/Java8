package com.df.dataStructure.stack_queue;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 225. 用队列实现栈
 *使用两个队列  一个是操作队列  一个是备用队列
 * push时都是放到queue1  需要取出是先将queue1备份到queue2
 * 完事后数据重新放回来
 * @author hanyli
 * @date 2021/3/5
 */
public class MyStack {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        this.queue1 = new LinkedList<>();
        this.queue2 = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        queue1.add(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        while (queue1.size() > 1) {
            queue2.add(queue1.poll());
        }
        //留取最后一个不删  需要返回的值
        int res = queue1.poll();
        //完事后数据恢复回来
        while (!queue2.isEmpty()) {
            queue1.add(queue2.poll());
        }
        return res;
    }

    /**
     * Get the top element.
     */
    public int top() {
        while (queue1.size() > 1) {
            queue2.add(queue1.poll());
        }
        Integer res = queue1.poll();
        //注意top不会删数据所以依然要放进queue2中
        queue2.add(res);
        while (!queue2.isEmpty()) {
            queue1.add(queue2.poll());
        }
        return res;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue1.isEmpty();
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.top();
        myStack.pop();
    }
}
