package com.labuladong.分类.dp.股票;

public class _152_乘积最大子数组 {

    /**
     * 动态规划
     * 思路：
     *  保存两组dp，分别存储当前位置最大/最小乘积
     *
     * 时间：O(n)
     * 空间：O(n)
     *
     */
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] maxF = new int[nums.length];
        int[] minF = new int[nums.length];

        maxF[0] = nums[0];
        minF[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxF[i] = Integer.max(maxF[i - 1] * nums[i], Integer.max(nums[i], minF[i - 1] * nums[i]));
            minF[i] = Integer.min(minF[i - 1] * nums[i], Integer.min(nums[i], maxF[i - 1] * nums[i]));
        }

        int ans = maxF[0];
        for (int i = 0; i < nums.length; i++) {
            ans = Integer.max(ans, maxF[i]);
        }

        return ans;
    }


    /**
     * 动态规划优化
     * 思路：由于dp计算时只与前面的值有关系，所以用常量保存即可
     *
     * 时间：O(n)
     * 空间：O(1)
     */
    public int maxProduct1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxF = nums[0];
        int minF = nums[0];

        int ans = maxF;
        for (int i = 1; i < nums.length; i++) {
            int mx = maxF;
            int mn = minF;
            maxF = Integer.max(mx * nums[i], Integer.max(nums[i], mn * nums[i]));
            minF = Integer.min(mn * nums[i], Integer.min(nums[i], mx * nums[i]));

            ans = Integer.max(ans, maxF);
        }

        return ans;
    }
}
