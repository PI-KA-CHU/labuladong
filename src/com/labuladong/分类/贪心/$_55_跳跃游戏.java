package com.labuladong.分类.贪心;

public class $_55_跳跃游戏 {

    public boolean canJump(int[] nums) {

        int n = nums.length;
        int rMost = 0;
        for (int i = 0; i < n; i++) {
            if (i <= rMost) {
                rMost = Integer.max(rMost, i + nums[i]);
            }

            if (rMost >= n - 1) {
                return true;
            }
        }

        return false;
    }

    /**
     * 推荐
     * 贪心算法
     * 思路：
     *  - 遍历数组，记录已经遍历的部分最远能够跳到的位置，每次遍历的时候判断当前位置是否是前面部分可以跳到的位置
     *  - 与_121_买卖股票思路类似，都是通过一次遍历，边遍历记录已经遍历过的部分的最大（小）值，用当前值与之计算
     *
     * 时间：O(n)
     * 空间：O(1)
     */
    public boolean canJump2(int[] nums) {

        int maxJump = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= maxJump) {
                maxJump = Integer.max(maxJump, i + nums[i]);
            } else {
                return false;
            }
        }

        return true;
    }
}
