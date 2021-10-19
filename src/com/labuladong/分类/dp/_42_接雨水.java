package com.labuladong.分类.dp;

public class _42_接雨水 {

    /**
     * 动态规划
     * 思路：按列求接的雨水值，在当前列的时候找出左右两边最大列的小的一列，用该列 - 当前列即为当前列装的雨水数
     *
     * 时间：O(n)
     * 空间：O(n)
     */

    public int trap(int[] height) {

        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 1; i < n; i++) {
            left[i] = Integer.max(left[i - 1], height[i - 1]);
        }

        for (int i = n - 2; i >= 0; i--) {
            right[i] = Integer.max(right[i + 1], height[i + 1]);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int subAns = Integer.min(left[i], right[i]) - height[i];
            if (subAns > 0) {
                ans += subAns;
            }
        }
        return ans;
    }
}
