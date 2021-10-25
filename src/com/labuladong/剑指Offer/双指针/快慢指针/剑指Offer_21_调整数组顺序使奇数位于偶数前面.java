package com.labuladong.剑指Offer.双指针.快慢指针;

public class 剑指Offer_21_调整数组顺序使奇数位于偶数前面 {

    /**
     * 双指针（快慢指针）
     *
     * 时间：O(n)
     * 空间：O(1)
     */
    public int[] exchange(int[] nums) {

        int slow = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 != 0) {
                int temp = nums[slow];
                nums[slow] = nums[i];
                nums[i] = temp;

                slow ++;
            }
        }

        return nums;
    }
}
