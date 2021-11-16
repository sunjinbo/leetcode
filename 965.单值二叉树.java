/*
 * @lc app=leetcode.cn id=965 lang=java
 *
 * [965] 单值二叉树
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
    public boolean isUnivalTree(TreeNode root) {
        if (root != null) {
            return isUnivalTree(root, root);
        }
        return false;
    }

    public boolean isUnivalTree(TreeNode parent, TreeNode current) {
        if (parent != null && current != null) {
            if (parent.val != current.val) {
                return false;
            }

            return isUnivalTree(current, current.left) && isUnivalTree(current, current.right);
        }
        return true;
    }
}
// @lc code=end

