package com.labuladong.其他;

public class _88_合并两个有序数组 {

    /**
     * 双指针
     * 思路：为了保证nums1原数组不会被覆盖，所以双指针指向两个数组的尾部，每次都取较大都值填入nums1尾部
     *
     * 时间：O(n)
     * 空间：O(1)
     *
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int p1 = m - 1;
        int p2 = n - 1;
        int tail = m + n - 1;

        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] > nums2[p2]) {
                nums1[tail--] = nums1[p1--];
            } else {
                nums1[tail--] = nums2[p2--];
            }
        }

        if (p1 < 0) {
            while (p2 >= 0) {
                nums1[tail--] = nums2[p2--];
            }
        } else {
            while (p1 >= 0) {
                nums1[tail--] = nums1[p1--];
            }
        }

    }
}
