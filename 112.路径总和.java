/*
 * @lc app=leetcode.cn id=112 lang=java
 *
 * [112] 路径总和
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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return pathSum(root, 0, targetSum);
    }

    public boolean pathSum(TreeNode root, int parentSum, int targetSum) {
        if (root != null) {
            if (root.left == null && root.right == null) {
                if (parentSum + root.val == targetSum) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return pathSum(root.left, parentSum + root.val, targetSum) 
                || pathSum(root.right, parentSum + root.val, targetSum);
            }
        } else {
            return false;
        }
    }
}
// @lc code=end

