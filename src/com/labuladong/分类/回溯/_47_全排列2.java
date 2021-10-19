package com.labuladong.分类.回溯;

import java.util.*;

public class _47_全排列2 {


    /**
     * 回溯 + 递归
     * 难点：
     * - 重复值的处理：(i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
     *
     */

    boolean[] used = new boolean[10];
    List<Integer> subAns = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {

        Arrays.sort(nums);
        backtract(nums);
        return ans;
    }

    public void backtract(int[] nums) {
        if (subAns.size() == nums.length) {
            ans.add(new ArrayList<>(subAns));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            // 被使用了 或者 当前节点值与上一个节点值相同，并且上一个节点还未被使用（不是在该节点的子遍历中）
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
                continue;
            }

            subAns.add(nums[i]);
            used[i] = true;
            backtract(nums);
            subAns.remove(subAns.size() - 1);
            used[i] = false;
        }
    }



    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        permuteUnique2(nums);
    }

    public static List<List<Integer>> permuteUnique2(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        // 排序（升序或者降序都可以），排序是剪枝的前提
        Arrays.sort(nums);

        boolean[] used = new boolean[len];
        // 使用 Deque 是 Java 官方 Stack 类的建议
        Deque<Integer> path = new ArrayDeque<>(len);
        dfs(nums, len, 0, used, path, res);
        return res;
    }

    private static void dfs(int[] nums, int len, int depth, boolean[] used, Deque<Integer> path, List<List<Integer>> res) {
        if (nums.length == path.size()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; ++i) {
            if (used[i]) {
                continue;
            }

            // 剪枝条件：i > 0 是为了保证 nums[i - 1] 有意义
            // 写 !used[i - 1] 是因为 nums[i - 1] 在深度优先遍历的过程中刚刚被撤销选择
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            path.addLast(nums[i]);
            used[i] = true;

            dfs(nums, len, depth + 1, used, path, res);
            // 回溯部分的代码，和 dfs 之前的代码是对称的
            used[i] = false;
            path.removeLast();
        }
    }

}
