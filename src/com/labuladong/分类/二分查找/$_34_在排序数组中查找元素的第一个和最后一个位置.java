package com.labuladong.分类.二分查找;

public class $_34_在排序数组中查找元素的第一个和最后一个位置 {

    /**
     * 二分搜索
     * 思路：套用寻找左右边界的模版，labuladong
     *
     * 时间：O(logn)
     * 空间：O(n)
     *
     */
    public static int[] searchRange(int[] nums, int target) {

        int left = binarySearchLeft(nums, target);
        int right = binarySearchRight(nums, target);

        return new int[]{left, right};
    }

    public static int binarySearchLeft(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid - 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (left >= nums.length || nums[left] != target) {
            return -1;
        }

        return left;
    }

    public static int binarySearchRight(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (right < 0 || nums[right] != target) {
            return -1;
        }

        return right;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,2,4,5};
        int[] ans = searchRange(nums, 2);
        for (int an : ans) {
            System.out.println(an);
        }
    }
}
