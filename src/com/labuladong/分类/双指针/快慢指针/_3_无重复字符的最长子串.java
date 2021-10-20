package com.labuladong.分类.双指针.快慢指针;

import java.util.HashMap;
import java.util.Map;

public class _3_无重复字符的最长子串 {

    /**
     * 双指针（快慢指针 - 滑动窗口）
     *
     * 思路：快慢都是闭指针
     */
    public static int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> map = new HashMap<>();

        //闭指针
        int slow = 0;
        int max = 0;

        //闭指针
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c) && map.get(c) >= slow) {
                slow = map.get(c) + 1;
            }
            max = Integer.max(max, i - slow + 1);
            map.put(c, i);
        }

        return max;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

}
