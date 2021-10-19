package com.labuladong.剑指Offer.位运算;

public class $剑指Offer_56_数组中数字出现的次数2 {

    public int singleNumber(int[] nums) {

        int[] count = new int[32];
        for (int num : nums) {
            for (int j = 0; j < 32; j++) {
                count[j] += num & 1;
                num >>= 1;
            }
        }

        // 对count % 3求余后，得到对就是那个没有重复数对位值，将其恢复
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res |= count[31 - i] % 3;
        }

        return res;
    }

}
