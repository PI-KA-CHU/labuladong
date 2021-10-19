package com.labuladong.剑指Offer.树;

import com.labuladong.分类.回溯.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class 剑指Offer54_二叉搜索树的第k大节点 {

    /**
     * 中序遍历
     *
     * 思路：二叉搜索树的中序遍历是递增的，所以获取ans.size() - k的元素即可
     * - 难点：需要确认当获取的k > ans.len时返回什么值。
     */
    List<Integer> ans = new ArrayList<>();

    public int kthLargest(TreeNode root, int k) {

        traverse(root, k);

        if (k > ans.size()) {
            return 0;
        }
        return ans.get(ans.size() - k);
    }


    public void traverse(TreeNode root, int targetK) {

        if (root == null) {
            return;
        }

        kthLargest(root.left, targetK);

        ans.add(root.val);

        kthLargest(root.right, targetK);
    }
}
