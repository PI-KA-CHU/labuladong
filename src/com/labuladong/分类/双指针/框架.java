package com.labuladong.分类.双指针;

import java.util.HashMap;
import java.util.Map;

public class 框架 {

    public void slidingWindow(String s, String t) {
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();

        int left = 0;
        int right = 0;
        int valid = 0; //int res = 0;

        for(char c : t.toCharArray()) need.put(c, need.get(c) + 1);

        while (right < s.length()) {
            char c = s.charAt(right);
            right++;

            //更新窗口数据
            window.put(c, window.get(c) + 1);

            //判断左窗口是否需要更新
            while (window.get(c) > 1) {
                char d = s.charAt(left);
                left ++;

                //更新窗口数据
                window.put(d, window.get(d) - 1);
            }

            // res = Integer.max(res, right - left);
        }

        //返回结果
    }
}
