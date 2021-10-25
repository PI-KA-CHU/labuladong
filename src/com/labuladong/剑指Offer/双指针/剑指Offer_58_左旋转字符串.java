package com.labuladong.剑指Offer.双指针;

public class 剑指Offer_58_左旋转字符串 {

    public String reverseLeftWords(String s, int n) {
        if (s == null) {
            return s;
        }

        return s.substring(n) + s.substring(0, n);
    }
}
