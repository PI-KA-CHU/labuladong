package com.labuladong.剑指Offer.贪心;

import java.util.Arrays;

public class 剑指Offer_45_把数组排成最小的数 {

    /**
     * 自定义排序
     * 思路：对源数组进行排序，若x + y > y + x，则x > y
     *
     */
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = nums[i] + "";
        }

        Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
        StringBuilder res = new StringBuilder();
        for (String str : strs) {
            res.append(str);
        }

        return res.toString();
    }
}
