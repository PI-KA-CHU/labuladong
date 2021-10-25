package com.labuladong.分类.双指针.滑动窗口;

import java.util.HashMap;
import java.util.Map;

public class $_76_最小覆盖子串 {

    /**
     * 滑动窗口
     *
     * 注意事项：
     * - Integer的判等需要用equal
     */
    public String minWindow(String s, String t) {
        //窗口中存储的是符合need字符的数量
        Map<Character, Integer> windows = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();

        int left = 0;
        int right = 0;
        int valid = 0;

        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int start = -1, len = Integer.MAX_VALUE;
        while (right < s.length()) {
            char c = s.charAt(right);
            right ++;

            //更新窗口
            if (need.containsKey(c)) {
                windows.put(c, windows.getOrDefault(c, 0) + 1);
                if (windows.get(c).equals(need.get(c))) {
                    valid ++;
                }
            }

            while (valid == need.size()) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }

                char d = s.charAt(left);
                left ++;

                if (need.containsKey(d)) {
                    if (windows.get(d).equals(need.get(d))) {
                        valid--;
                    }

                    windows.put(d, windows.get(d) - 1);
                }
            }

        }

        return start == -1 ? "" : s.substring(start, start + len);

    }

    public String minWindow1(String s, String t) {

        Map<Character, Integer> windows = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();

        int left = 0;
        int right = 0;
        int valid = 0;

        int start = -1;
        int len = Integer.MAX_VALUE;
        for (int i = 0; i < t.length(); i++) {
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }

        while (right < s.length()) {
            char c = s.charAt(right);
            right ++;

            if (need.containsKey(c)) {
                windows.put(c, windows.getOrDefault(c, 0) + 1);
                if (windows.get(c).equals(need.get(c))) {
                    valid ++;
                }
            }

            while (need.size() == valid) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }

                char d = s.charAt(left);
                left ++;

                if (need.containsKey(d)) {
                    if (windows.get(d).equals(need.get(d))) {
                        valid --;
                    }
                    windows.put(d, windows.get(d) - 1);
                }
            }
        }

        return start == -1 ? "" : s.substring(start, start + len);
    }

}
