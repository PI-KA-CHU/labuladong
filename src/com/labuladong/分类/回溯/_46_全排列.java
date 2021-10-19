package com.labuladong.分类.回溯;

import java.util.ArrayList;
import java.util.List;

public class _46_全排列 {

    boolean[] numUsed = new boolean[10];
    List<Integer> subAns = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        backtract(nums);
        return ans;
    }

    public void backtract(int[] nums) {
        if (subAns.size() == nums.length) {
            ans.add(new ArrayList<>(subAns));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!numUsed[i]) {
                subAns.add(nums[i]);
                numUsed[i] = true;
                backtract(nums);
                subAns.remove(subAns.size() - 1);
                numUsed[i] = false;
            }
        }
    }
}
