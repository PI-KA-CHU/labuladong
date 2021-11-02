package com.labuladong.其他;

import java.util.*;

public class _49_字母异位词分组 {

    /**
     *
     * 将字符串排序后作为key，val保存其相同key的List
     *
     * 时间：O(nklog(k))
     * 空间：O(n)
     *
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            List<String> valList = map.getOrDefault(key, new ArrayList<>());
            valList.add(s);
            map.put(key, valList);
        }

        return new ArrayList<>(map.values());
    }
}
