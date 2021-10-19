package com.labuladong.分类.回溯;

public class _494_目标和 {

    /**
     *
     * 时间复杂度：2^n
     * 空间复杂度：O(n)
     */
    int ans = 0;
    boolean[] used = new boolean[21];
    public int findTargetSumWays(int[] nums, int target) {

        backtract(nums, target, 0);

        return ans;
    }

    /**
     * @param index index用于对某层的控制，对应到回溯树的某层，在此处是计算到某个nums
     */
    public void backtract(int[] nums, int target, int index) {
        if (index == nums.length) {
            if (target == 0) {
                ans ++;
            }
            return;
        }

        // 此处的是选择，画出回溯树，这里就是分支的遍历
        backtract(nums, target - nums[index], index + 1);
        backtract(nums, target + nums[index], index + 1);
    }
}
