package com.labuladong.剑指Offer;

public class 剑指Offer_05_替换空格 {

    public String replaceSpace(String s) {

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                ans.append("%20");
            } else {
                ans.append(c);
            }
        }

        return ans.toString();
    }
}
