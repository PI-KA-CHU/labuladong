package com.labuladong.剑指Offer;

public class 剑指Offer_17_打印从1到最大的n位数 {

    public int[] printNumbers(int n) {

        int num = (int) Math.pow(10 ,n);

        int[] ans = new int[num - 1];
        for (int i = 1; i < num; i++) {
            ans[i - 1] = i;
        }

        return ans;
    }
}
