package com.labuladong.剑指Offer.双指针.左右指针;

import com.sun.xml.internal.ws.util.HandlerAnnotationInfo;

public class 剑指Offer_57_和为s的两个数字 {

    /**
     *
     *
     *
     */
    public int[] twoSum0(int[] nums, int target) {

        int[] ans = new int[2];

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                ans[0] = nums[left];
                ans[1] = nums[right];
                return ans;
            } else if (sum < target) {
                left ++;
            } else {
                right --;
            }
        }

        return ans;
    }


    /**
     *
     * 时间：O(nlogn)
     * 空间：O(1)
     */
    public int[] twoSum(int[] nums, int target) {

        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int t = target - nums[i];
            if (t < nums[i]) {
                return ans;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (t == nums[mid]) {
                    ans[0] = nums[i];
                    ans[1] = t;
                    return ans;
                } else if (t < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }

        return ans;
    }

}
