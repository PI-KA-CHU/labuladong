package com.labuladong.分类.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _78_子集 {

    boolean[] used = new boolean[11];
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);
        tractback(nums, new ArrayList<>(), ans, 0);

        return ans;
    }

    public void tractback(int[] nums, List<Integer> subAns, List<List<Integer>> ans, int begin) {

        ans.add(new ArrayList<>(subAns));
        if (subAns.size() == nums.length) {
            return;
        }

        for (int i = begin; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            subAns.add(nums[i]);
            used[i] = true;
            tractback(nums, subAns, ans, i);
            subAns.remove(subAns.size() - 1);
            used[i] = false;
        }
    }
}
