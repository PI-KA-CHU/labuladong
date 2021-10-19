package com.labuladong.剑指Offer;

public class 剑指Offer_10_青蛙跳台阶问题 {

    public static int numWays(int n) {
        final int MOD = 1000000007;
        if (n < 2) {
            return 1;
        }

        int pre1 = 1;
        int pre2 = 1;
        int curr = 0;
        for (int i = 2; i <= n; i++) {
            curr = (pre1 + pre2) % MOD;
            pre1 = pre2;
            pre2 = curr;
        }

        return curr;
    }

    public static void main(String[] args) {
        System.out.println(numWays(7));
    }
}
