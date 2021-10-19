package com.labuladong.分类.回溯;

import java.util.*;

public class $_39_组合总和 {

    /**
     * 回溯 + 剪枝
     *
     * 思路：
     * - 与全排列相比，不需要控制字符是否被使用（组合的元素可以多次使用）
     * - 需要控制组合是否重复
     *
     */
    List<Integer> subAns = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        // 排序是为了剪枝
        Arrays.sort(candidates);
        backtract(candidates, target, 0);
        return ans;
    }

    public void backtract(int[] candidates, int target, int begin) {
        if (target == 0) {
            ans.add(new ArrayList<>(subAns));
        }

        // 此处的i以begin开始，含义是某层的后续子树的遍历中，都不要使用该层已经使用过的点（理解起来比较困难，直接记着吧）
        for (int i = begin; i < candidates.length; i++) {
            // 因为数组已经做递增排序，此处剪枝
            if (target - candidates[i] < 0) {
                break;
            }

            subAns.add(candidates[i]);
            backtract(candidates, target - candidates[i], i);
            subAns.remove(subAns.size() - 1);
        }
    }

}
