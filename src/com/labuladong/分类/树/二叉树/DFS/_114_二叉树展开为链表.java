package com.labuladong.分类.树.二叉树.DFS;

import com.labuladong.分类.树.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class _114_二叉树展开为链表 {


    /**
     * *推荐：
     * 前序遍历如果对右子树做操作，由于右树还没遍历，会导致节点丢失，而后序遍历不会。
     * 所以我们可以根据后序遍历进行操作。
     *
     * 时间：O(n)
     * 空间：O(1)
     */
    public void flatten0(TreeNode root) {
        if (root == null) {
            return;
        }

        flatten0(root.left);
        flatten0(root.right);

        // 1.储存right, 移接left（置为null），找到末端，接入right
        TreeNode right = root.right;
        root.right = root.left;
        root.left = null;

        while (root.right != null) {
            root = root.right;
        }

        root.right = right;
    }


    /**
     * 
     * @param root
     */
    public void flatten(TreeNode root) {

        if (root == null) {
            return;
        }

        TreeNode node = root;
        while (node.right != null) {
            node = node.right;
        }
        node.right = root.left;
        flatten(root.left);
        flatten(root.right);
    }


    /**
     * 解法二：
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */

    //该列表中存储着各个Node的指针
    List<TreeNode> ans = new ArrayList<>();

    public void flatten2(TreeNode root) {

        if (root == null) {
            return;
        }

        preorderTraversal(root);

        for (int i = 1; i < ans.size(); i++) {
            TreeNode pre = ans.get(i - 1);
            TreeNode curr = ans.get(i);
            pre.left = null;
            pre.right = curr;
        }
    }

    public void preorderTraversal(TreeNode root) {

        if (root == null) {
            return;
        }

        ans.add(root);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }


}
