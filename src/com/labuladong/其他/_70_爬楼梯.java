package com.labuladong.其他;

public class _70_爬楼梯 {

    public _70_爬楼梯() {
    }

    public int climbStairs(int n) {

        if (n <= 2) {
            return n;
        }

        int p1 = 1;
        int p2 = 2;

        int ans = 0;
        for (int i = 3; i <= n; i++) {
            ans = p1 + p2;
            p1 = p2;
            p2 = ans;
        }

        return ans;
    }
}
