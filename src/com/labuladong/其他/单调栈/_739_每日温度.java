package com.labuladong.其他.单调栈;

import java.util.ArrayDeque;
import java.util.Deque;

public class _739_每日温度 {

    public int[] dailyTemperatures(int[] temperatures) {

        Deque<Integer> stack = new ArrayDeque<>();

        int[] ans = new int[temperatures.length];
        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }

            ans[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }

        return ans;
    }
}
