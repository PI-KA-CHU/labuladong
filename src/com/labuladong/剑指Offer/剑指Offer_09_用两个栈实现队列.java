package com.labuladong.剑指Offer;

import java.util.Stack;

public class 剑指Offer_09_用两个栈实现队列 {

    /**
     * 插入/删除时间复杂度：O(1)
     * 空间负责度：O(n)
     */
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public 剑指Offer_09_用两个栈实现队列() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (!stack2.isEmpty()) return stack2.pop();
        if (stack1.isEmpty()) return -1;
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }
}
