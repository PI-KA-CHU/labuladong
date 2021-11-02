package com.labuladong.分类.回溯;

import java.util.ArrayList;
import java.util.List;

public class _301_删除无效的括号 {

    public List<String> removeInvalidParentheses(String s) {

        int lremove = 0;
        int rremove = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                lremove ++;
            } else if (s.charAt(i) == ')') {
                if (lremove == 0) {
                    rremove++;
                } else {
                    lremove --;
                }
            }
        }

        List<String> ans = new ArrayList<>();
        backtract(ans, s, lremove, rremove, 0);

        return ans;
    }

    public void backtract(List<String> ans, String s, int lremove, int rremove, int begin) {

        if (lremove == 0 && rremove == 0) {
            if (valid(s)) {
                ans.add(s);
            }
        }

        /**
         * 1. 需要顺序遍历选择，并且不能重复选的，则使用for + begin
         * 2. 不需要顺序遍历选择（跳跃性选择），并且不能重复选的，则使用for + used[]
         * 3. 如果求的是子集，则不需要用到for，直接用index传参，并做选/不选的选择即可
         */
        for (int i = begin; i < s.length(); i++) {
            //两个相同的括号在一起，删除前面的或者删除后面的都是同样的结果，这是导致重复的原因
            if (i > 0 && s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }

            char c = s.charAt(i);
            if (lremove > 0 && c == '(') {
                backtract(ans,s.substring(0, i) + s.substring(i + 1), lremove - 1, rremove, i);
            }

            if (rremove > 0 && c == ')') {
                backtract(ans, s.substring(0, i) + s.substring(i + 1), lremove, rremove - 1, i);
            }

        }

    }

    private boolean valid(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                cnt ++;
            } else if (s.charAt(i) == ')') {
                if (cnt > 0) {
                    cnt--;
                } else {
                    return false;
                }
            }
        }

        return cnt == 0;
    }
}
