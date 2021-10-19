package com.labuladong.力扣周赛;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class _5904_统计按位或能得到最大值的子集数目 {

    int ans = 0;
    public int countMaxOrSubsets0(int[] nums) {
        int max = 0;

        for (int num : nums) {
            max |= num;
        }

        dfs(nums, max, 0, 0);
        return ans;
    }

    public void dfs(int[] nums, int target, int curr, int index) {
        // 剪枝
        if (target == curr) {
            ans += 1 << nums.length - index;
            return;
        }

        if (index == nums.length) {
            return;
        }

        // 加上当前数
        dfs(nums, target, curr | nums[index], index + 1);
        // 不加上当前数
        dfs(nums, target, curr, index + 1);

    }


    public static void dfs(int[] nums, List<List<Integer>> ans, List<Integer> subAns, int index) {
        if (index == nums.length) {
            ans.add(new ArrayList<>(subAns));
            return;
        }

        subAns.add(nums[index]);
        dfs(nums, ans, subAns, index + 1);
        subAns.remove(subAns.size() - 1);
        dfs(nums, ans, subAns, index + 1);
    }


    static boolean[] used = new boolean[17];
    public static int countMaxOrSubsets(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        backtract(ans, new ArrayList<>(), nums, 0);

        int max = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < ans.size(); i++) {
            List<Integer> sub = ans.get(i);

            int orV = sub.get(0);
            for (int j = 1; j < sub.size(); j++) {
                 orV |= sub.get(j);
            }

            if (orV > max) {
                max = orV;
                count = 1;
            } else if (orV == max) {
                count ++;
            }
        }

        return count;
    }

    public static void backtract(List<List<Integer>> ans, List<Integer> subAns, int[] nums, int begin) {

        for (int i = begin; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }

            used[i] = true;
            subAns.add(nums[i]);
            ans.add(new ArrayList<>(subAns));
            backtract(ans, subAns, nums, i);
            subAns.remove(subAns.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 2};

        List<List<Integer>> ans = new ArrayList<>();
        dfs(nums, ans, new ArrayList<>(), 0);

        System.out.println(ans);
    }
}
