package com.labuladong.力扣周赛;

public class _5902_检查句子中的数字是否递增 {

    public boolean areNumbersAscending(String s) {

        String[] s1 = s.split(" ");
        int pre = Integer.MIN_VALUE;

        for (String value : s1) {
            if (value.charAt(0) >= '0' && value.charAt(0) <= '9') {
                int val = Integer.parseInt(value);
                if (val <= pre) {
                    return false;
                }
                pre = val;
            }
        }

        return true;
    }


}
