package com.labuladong.其他;

import java.util.ArrayDeque;
import java.util.Deque;

public class _155_最小栈 {

    Deque<Integer> min_stack;
    Deque<Integer> stack;

    public _155_最小栈() {
        min_stack = new ArrayDeque<>();
        min_stack.push(Integer.MAX_VALUE);
        stack = new ArrayDeque<>();
    }

    public void push(int val) {
        stack.push(val);
        min_stack.push(Math.min(min_stack.peek(), val));
    }

    public void pop() {
        stack.pop();
        min_stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min_stack.peek();
    }
}
