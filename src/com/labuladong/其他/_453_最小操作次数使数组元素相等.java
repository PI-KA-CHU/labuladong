package com.labuladong.其他;

import java.util.Arrays;

public class _453_最小操作次数使数组元素相等 {

    public int minMoves(int[] nums) {

        int min = Arrays.stream(nums).min().getAsInt();
        int res = 0;

        for (int num : nums) {
            res += num - min;
        }

        return res;
    }
}
