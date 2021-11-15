/*
 * @lc app=leetcode.cn id=938 lang=java
 *
 * [938] 二叉搜索树的范围和
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
    public int rangeSumBST(TreeNode root, int low, int high) {
        int sum = 0;
        if (root != null) {
            if (root.val >= low && root.val <= high) {
                sum += root.val;
            }
            sum += rangeSumBST(root.left, low, high);
            sum += rangeSumBST(root.right, low, high);
        }
        return sum;
    }
}
// @lc code=end

