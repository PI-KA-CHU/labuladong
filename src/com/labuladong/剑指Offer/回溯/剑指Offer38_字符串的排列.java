package com.labuladong.剑指Offer.回溯;

import java.util.*;

public class 剑指Offer38_字符串的排列 {

    StringBuilder subAns = new StringBuilder();
    Map<Integer, Integer> map = new HashMap<>();
    Set<String> ans = new HashSet<>();
    public String[] permutation(String s) {

        traverse(s);

        int i = 0;
        String[] res = new String[ans.size()];
        for (String s1 : ans) {
            res[i++] = s1;
        }

        return res;
    }

    public void traverse(String s) {
        if (subAns.length() == s.length()) {
            ans.add(subAns.toString());
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(i)) {
                subAns.append(s.charAt(i));
                map.put(i, i);
                traverse(s);
                map.remove(i);
                subAns.deleteCharAt(subAns.length() - 1);
            }
        }
    }
}
