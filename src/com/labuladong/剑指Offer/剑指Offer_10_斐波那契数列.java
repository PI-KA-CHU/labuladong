package com.labuladong.剑指Offer;

public class 剑指Offer_10_斐波那契数列 {

    public static int fib(int n) {
        final int MOD = 1000000007;
        if (n < 2) {
            return n;
        }

        int pre1 = 0;
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
        System.out.println(fib(45));
    }
}
