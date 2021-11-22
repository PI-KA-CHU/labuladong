package com.labuladong.分类.dp;

import jdk.nashorn.internal.objects.NativeUint8Array;

public class _494_目标和 {

    int count;
    public int findTargetSumWays(int[] nums, int target) {
        backtract(nums, target, 0);

        return count;
    }

    public void backtract(int[] nums, int val, int i) {
        if (i == nums.length) {
            if (val == 0) {
                count++;
            }
            return;
        }

        backtract(nums, val + nums[i], i + 1);
        backtract(nums, val - nums[i], i + 1);
    }
}
