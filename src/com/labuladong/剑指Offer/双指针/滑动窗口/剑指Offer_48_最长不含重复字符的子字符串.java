package com.labuladong.剑指Offer.双指针.滑动窗口;

import java.util.HashMap;
import java.util.Map;

public class 剑指Offer_48_最长不含重复字符的子字符串 {

    public static int lengthOfLongestSubstring(String s) {

        int left = 0;
        int right = 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();

        while (right < s.length()) {
            char c = s.charAt(right);
            right ++;

            map.put(c, map.getOrDefault(c, 0) + 1);

            while (map.get(c) > 1) {
                char l = s.charAt(left);
                left ++;
                map.put(l, map.get(l) - 1);
            }

            max = Integer.max(max, right - left);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
