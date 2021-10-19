package com.labuladong.分类.贪心;

import java.util.Arrays;

public class $_581_最短无序连续子数组 {


    /**
     * 思路：对于正常排序的数组部分，在排序后位置仍然不变，
     * 所以将原数组与排序后的数组对比，错位的头和尾即为需要重新排序的数组
     *
     * 时间：O(nlog(n))
     * 空间：O(n)
     */
    public int findUnsortedSubarray(int[] nums) {

        int[] numsC = nums.clone();
        Arrays.sort(numsC);

        int l = -1;
        int r = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != numsC[i]) {
                if (l == -1) {
                    l = i;
                } else {
                    r = i;
                }
            }
        }

        return r == -1 ? 0 : r - l + 1;
    }

}
