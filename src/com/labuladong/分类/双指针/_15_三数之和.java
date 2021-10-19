package com.labuladong.分类.双指针;

import java.util.ArrayList;
import java.util.List;

public class _15_三数之和 {

    public List<List<Integer>> threeSum(int[] nums) {

        int len = nums.length;
        int left = 0;
        int right = len - 1;
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < len; i++) {

            if (nums[i] > 0) {
                break;
            }

            left = i + 1;
            right = len - 1;

            List<Integer> subAns = new ArrayList<>();
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    subAns.add(nums[i]);
                    subAns.add(nums[left]);
                    subAns.add(nums[right]);
                } else if (sum > 0) {
                    right--;
                } else {
                    left ++;
                }
            }
            ans.add(subAns);
        }

        return ans;
    }

}
