package com.labuladong.每日刷题;

public class _66_加一 {

    public int[] plusOne(int[] digits) {

        int n = 1;
        int l = digits.length - 1;

        while (n == 1) {
            int d = digits[l] + 1;
            digits[l] = d % 10;
            if (d >= 10) {
                l --;

                // 处理{99}这类需要进位的
                if (l < 0) {
                    int[] nums = new int[digits.length + 1];
                    nums[0] = 1;
                    return nums;
                }
            } else {
                n = 0;
            }
        }

        return digits;
    }
}
