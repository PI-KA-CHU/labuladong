package com.labuladong.剑指Offer;

import java.util.HashSet;
import java.util.Set;

public class 剑指Offer_03_数组中重复的数字 {

    /**
     * 时间：O(n)
     * 空间：O(n)
     */
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return nums[i];
            }
            set.add(nums[i]);
        }

        return -1;
    }

    /**
     * 原地交换
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * 难点：每一个点在交换前后都需要做一次判断，如果不满足则继续交换，故此处得用while
     *
     */
    public static int findRepeatNumber2(int[] nums) {

        int i = 0;
        while(i < nums.length) {
            if(nums[i] == i) {
                i++;
                continue;
            }
            if(nums[nums[i]] == nums[i]) return nums[i];
            int tmp = nums[i];
            nums[i] = nums[tmp];
            nums[tmp] = tmp;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, 2, 0, 0, 1};
        findRepeatNumber2(nums);
    }

}
