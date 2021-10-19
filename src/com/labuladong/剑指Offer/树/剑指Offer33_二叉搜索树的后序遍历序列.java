package com.labuladong.剑指Offer.树;

public class 剑指Offer33_二叉搜索树的后序遍历序列 {


    /**
     * 递归分治
     * 思路：从左往右依次遍历，找到第一个大于root值的下标（该下标前面都是左子节点）
     * 继续找到第一个不大于root值的小标，如果这是正常的二叉搜索树，则该下标为root下标。
     *
     * 时间：O(n^2)
     * 空间：O(n)
     */
    public boolean verifyPostorder(int[] postorder) {

        return recur(postorder, 0, postorder.length - 1);
    }

    public boolean recur(int[] postorder, int p1, int p2) {

        if (p1 >= p2) {
            return true;
        }

        int p = p1;
        while (postorder[p] < postorder[p2]) p++;
        int m = p;
        while (postorder[p] > postorder[p2]) p++;

        return p == p2 && recur(postorder, p1, m - 1) && recur(postorder, m, p2 - 1);
    }
}
