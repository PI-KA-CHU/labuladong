package com.labuladong.其他.单调栈;

import java.util.ArrayDeque;
import java.util.Deque;

public class _503_下一个更大元素2 {

    public int[] nextGreaterElements(int[] nums) {
        Deque<Integer> s = new ArrayDeque<>();
        int n = nums.length;
        int[] ans = new int[n];

        //此处模拟环状数组（将数组翻倍变长）
        for (int i = 2*n - 1; i >= 0; i--) {
            while (!s.isEmpty() && s.peek() <= nums[i % n]) {
                s.pop();
            }
            ans[i % n] = s.isEmpty() ? -1 : s.peek();
            s.push(nums[i % n]);
        }

        return ans;
    }
}
