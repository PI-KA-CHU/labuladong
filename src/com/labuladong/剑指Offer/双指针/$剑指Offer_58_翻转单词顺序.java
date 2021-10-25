package com.labuladong.剑指Offer.双指针;

public class $剑指Offer_58_翻转单词顺序 {

    /**
     *
     * 时间: O(n)
     * 空间: O(n)
     *
     * 注意事项：
     * - split(" ")如果单词间有多个空格，会出现空字符的情况，所以需要剔除
     * - 利用trim清空前后的空格
     */
    public static String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        String[] s1 = s.split(" ");
        StringBuilder ans = new StringBuilder();
        for (int i = s1.length - 1; i >= 0; i --) {
            String s2 = s1[i];

            if (s2.length() == 0) {
                continue;
            }
            ans.append(s2).append(" ");
        }

        return ans.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("  hello world!  "));
    }
}
