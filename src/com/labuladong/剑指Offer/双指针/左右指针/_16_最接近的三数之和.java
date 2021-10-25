package com.labuladong.剑指Offer.双指针.左右指针;

import java.util.Arrays;

public class _16_最接近的三数之和 {

    public static int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);

        int left = 0;
        int right = 0;

        int min = Integer.MAX_VALUE;
        int res = 0;

        for (int i = 0; i < nums.length; i++) {

            left = i + 1;
            right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                int diff = Math.abs(target - sum);
                if (diff < min) {
                    min = diff;
                    res = sum;
                }

                if (sum == target) {
                    return target;
                } else if (sum > target) {
                    right--;
                } else {
                    left ++;
                }
            }

        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        System.out.println(threeSumClosest(nums, 1));
    }
}
