package com.labuladong.剑指Offer.位运算;

public class 剑指Offer_56_数组中数字出现的次数 {

    /**
     * 位运算
     * 思路：相同数异或结果为，对所有数异或得到题目的两个不同数的异或值，
     *       找到该值中出现的第一个值为1的地方（说明对于两个数该位置的位不同），根据该位置划分为两组即可
     * 注意事项：
     * - (num & diff) != 0可以判断该位置的奇偶性，但是不能用 == 1判断，该与结果是等于0或大于0，而不是简单的0或1
     */
    public static int[] singleNumbers(int[] nums) {

        int ret = 0;
        for (int num : nums) {
            ret ^= num;
        }

        //找到a,b两个数中位置不同的地方
        int diff = 1;
        while ((ret & diff) == 0) {
            diff <<= 1;
        }

        //根据该位置即可将两个不同的数分到两组，而其他数相同的数会分到同一组（随机）
        int a = 0;
        int b = 0;
        for (int num : nums) {
            // 奇偶判断要用 != 0
            if ((num & diff) != 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }

        return new int[]{a, b};
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 5, 2};
        System.out.println(singleNumbers(nums));
    }
}
