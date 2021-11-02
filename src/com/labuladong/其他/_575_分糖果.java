package com.labuladong.其他;

import java.util.HashSet;
import java.util.Set;

public class _575_分糖果 {

    public int distributeCandies(int[] candyType) {

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < candyType.length; i++) {
            set.add(candyType[i]);
        }

        int avg = candyType.length / 2;
        int type = set.size();

        return Math.min(avg, type);
    }
}
