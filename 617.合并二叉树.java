/*
 * @lc app=leetcode.cn id=617 lang=java
 *
 * [617] 合并二叉树
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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 != null || root2 != null) {
            int val = (root1 != null ? root1.val : 0) 
                + (root2 != null ? root2.val : 0);
            TreeNode node = new TreeNode(val);
            node.left = mergeTrees(root1 != null ? root1.left : null, root2 != null ? root2.left : null);
            node.right = mergeTrees(root1 != null ? root1.right : null, root2 != null ? root2.right : null);
            return node;
        }
        return null;
    }
}
// @lc code=end

