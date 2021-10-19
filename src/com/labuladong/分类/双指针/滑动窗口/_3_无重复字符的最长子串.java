package com.labuladong.分类.双指针.滑动窗口;

import java.util.HashMap;
import java.util.Map;

public class _3_无重复字符的最长子串 {


    /**
     * 推荐
     * 滑动窗口（套框架）
     *
     * 时间：O(n)
     * 空间：O(n)
     */
    public static int lengthOfLongestSubstring(String s) {

        int left = 0;
        int right = 0;
        int res = 0;

        Map<Character, Integer> windows = new HashMap<>();

        while (right < s.length()) {
            char c = s.charAt(right);
            right ++;

            int origin = windows.getOrDefault(c, 0);
            windows.put(c, origin + 1);

            while (windows.get(c) > 1) {
                char d = s.charAt(left);
                left++;

                windows.put(d, windows.get(d) - 1);
            }

            res = Integer.max(res, right - left);
        }

        return res;
    }

    public static void main(String[] args) {
        lengthOfLongestSubstring(" ");
    }

}
