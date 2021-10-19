package com.labuladong.剑指Offer.二分查找;

public class $剑指Offer_53_0_n_1中缺失的数字 {

    /**
     * 二分搜索
     * 思路：如果正常情况下，该数组对index与值相同，
     *      所以可以利用二分搜索找到第一个index不等于值的index，该index为所求
     *
     * 注意事项：需要熟悉二分搜索的框架，如果while里是：
     *          - left < right, 则right = num.length，否则会缺失单个元素的数组
     *          - left <= right，则right = num.length - 1
     */
    public int missingNumber(int[] nums) {
        int left = 0;
        int right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid == nums[mid]) left = mid + 1;
            else right = mid;
        }

        return left;
    }

}
