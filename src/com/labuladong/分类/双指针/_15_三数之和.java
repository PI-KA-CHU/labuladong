package com.labuladong.分类.双指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _15_三数之和 {

    /**
     * 双指针
     *
     * 注意事项：
     * - 去重、减枝
     *
     * 错误：
     * - left、right需要在每次循环的时候都更新
     */
    public List<List<Integer>> threeSum(int[] nums) {

        int left = 0;
        int right = 0;
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            left = i + 1;
            right = nums.length - 1;

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left ++;
                    right --;

                    while (left < right && nums[left] == nums[left - 1]) left ++;
                    while (left < right && nums[right] == nums[right + 1]) right --;
                } else if (sum > 0) {
                    right--;
                } else {
                    left ++;
                }
            }
        }

        return ans;
    }

}
