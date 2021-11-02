package com.labuladong.其他.单调栈;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class _496_下一个更大元素 {

    /**
     * 单调栈
     * 思路：
     *  Next Greater Number系列题目，从后到前将数将入栈，遇到当前数值大于栈顶，则将数出栈，
     *  当栈顶元素当与当前元素，则为所求
     *
     * 注意事项：
     * - map在push的时候需要考虑stack为空的情况
     *
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Deque<Integer> stack = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }

            map.put(nums2[i], stack.isEmpty() ? - 1 : stack.peek());
            stack.push(nums2[i]);
        }

        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }

        return res;
    }
}
