package com.labuladong.分类.树.二叉树;

public class _108_将有序数组转换为二叉搜索树 {

    /**
     * 推荐
     * 根据中序遍历的有序递增性，递归构建根节点
     *
     * 时间：O(n)
     * 空间：O(log(n))，平衡二叉树的树高度为log(n)
     *
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }

    public TreeNode buildTree(int[] nums, int i1, int i2){
        if (i1 > i2) {
            return null;
        }

        int rootIndex = (i1 + i2) / 2;
        TreeNode root = new TreeNode(nums[rootIndex]);
        root.left = buildTree(nums, i1, rootIndex - 1);
        root.right = buildTree(nums, rootIndex + 1, i2);

        return root;
    }
}
