package com.labuladong.分类.树.前缀树;

import java.util.HashMap;
import java.util.Map;

public class _560_和为K的子数组 {

    /**
     * 前缀树
     *
     */
    public int subarraySum0(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int pre = 0;
        int ans = 0;

        for (int num : nums) {
            pre += num;
            if (map.containsKey(pre - k)) {
                ans += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }

        return ans;
    }

    /**
     * 暴力枚举
     *
     * 时间：O(n^2)
     * 空间：O(1)
     */
    public static int subarraySum(int[] nums, int k) {

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    count ++;
                }
            }
        }

        return count;
    }

    public int subarraySum2(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int sum = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                ans += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        int k = 2;
        subarraySum(nums, k);
    }
}
