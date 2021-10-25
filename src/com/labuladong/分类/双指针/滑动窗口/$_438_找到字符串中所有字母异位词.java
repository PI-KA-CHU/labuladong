package com.labuladong.分类.双指针.滑动窗口;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class $_438_找到字符串中所有字母异位词 {

    /**
     * 滑动窗口
     * 思路：套用模版
     *
     * 注意事项：
     * - 模版的窗口缩小条件不同
     * - 缩小时对valid的操作是在need.get(c) == window.get(c)的时候
     *
     */
    public List<Integer> findAnagrams(String s, String p) {

        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        List<Integer> ans = new ArrayList<>();

        int left = 0;
        int right = 0;
        int valid = 0;

        for (char c : p.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        while (right < s.length()) {
            char c = s.charAt(right);
            right ++;

            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);

                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            while (right - left >= p.length()) {
                if (valid == need.size()) {
                    ans.add(left);
                }

                char d = s.charAt(left);
                left ++;

                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid --;
                    }

                    window.put(d, window.get(d) - 1);
                }
            }
        }

        return ans;
    }
}
