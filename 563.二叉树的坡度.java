/*
 * @lc app=leetcode.cn id=563 lang=java
 *
 * [563] 二叉树的坡度
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
    int ans = 0;

    public int findTilt(TreeNode root) {
        bfs(root);
        return ans;
    }

    public int bfs(TreeNode root) {
        if (root == null) return 0;

        int leftTilt = 0;
        int rightTilt = 0;

        leftTilt = bfs(root.left);
        rightTilt = bfs(root.right);

        ans += Math.abs(leftTilt - rightTilt);

        return leftTilt + rightTilt + root.val;
    }
}
// @lc code=end

