package com.labuladong.分类.回溯;

import java.util.ArrayList;
import java.util.List;

public class _22_括号生成 {


    /**
     * 回溯法
     *
     * 思路：
     * - 当开括号小于n时，添加开括号
     * - 当闭括号小于开括号时（剪枝），才添加闭括号
     *
     */
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<String>();

        backtract(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    public void backtract(List<String> ans, StringBuilder curr, int open, int close, int max) {

        if (curr.length() == 2 * max) {
            ans.add(curr.toString());
        }

        if (open < max) {
            curr.append("(");
            backtract(ans, curr, open + 1, close, max);
            curr.deleteCharAt(curr.length() - 1);
        }

        if (close < open) {
            curr.append(")");
            backtract(ans, curr, open, close + 1, max);
            curr.deleteCharAt(curr.length() - 1);
        }

    }

}
