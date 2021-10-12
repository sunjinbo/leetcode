/*
 * @lc app=leetcode.cn id=110 lang=java
 *
 * [110] 平衡二叉树
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        return isBalancedTree(root);
    }

    public boolean isBalancedTree(TreeNode tree) {
        if (tree == null) return true;
        return isBalancedTree(tree.left) 
            &&  isBalancedTree(tree.right)
            && Math.abs(treeDepth(tree.left) - treeDepth(tree.right)) <= 1;
    }

    public int treeDepth(TreeNode tree) {
        if (tree == null) return 0;
        return 1 + Math.max(treeDepth(tree.left), treeDepth(tree.right));
    }
}
// @lc code=end

