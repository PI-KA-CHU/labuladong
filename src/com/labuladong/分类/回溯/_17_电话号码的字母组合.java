package com.labuladong.分类.回溯;

import java.util.*;

public class _17_电话号码的字母组合 {

    public static List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.isEmpty()) {
            return ans;
        }

        Map<Character, String> map = new HashMap<Character, String>(){{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};

        backtract(map, new StringBuilder(), ans, 0, digits);

        return ans;
    }

    public static void backtract(Map<Character,String> origin, StringBuilder subAns, List<String> ans, int k, String digits) {
        if (k == digits.length()) {
            ans.add(subAns.toString());
            return;
        }

        String s = origin.get(digits.charAt(k));
        for (int i = 0; i < s.length(); i++) {
            subAns.append(s.charAt(i));
            backtract(origin, subAns, ans, k + 1, digits);
            subAns.deleteCharAt(subAns.length() - 1);
        }
    }

    public static void main(String[] args) {
        String str = "23";
        letterCombinations(str);
    }
}
