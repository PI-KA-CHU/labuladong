package com.labuladong.剑指Offer.位运算;

public class 剑指Offer_15_二进制中1的个数 {

    /**
     *
     * n & (n - 1)：最右边的1变成0
     *
     */
    public int hammingWeight(int n) {

        int count = 0;
        while (n != 0) {
            n &= (n - 1);
            count ++;
        }

        return count;
    }
}
