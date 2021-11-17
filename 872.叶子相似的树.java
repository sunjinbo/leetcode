/*
 * @lc app=leetcode.cn id=872 lang=java
 *
 * [872] 叶子相似的树
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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        traverseTree(root1, sb1);
        traverseTree(root2, sb2);
        return sb1.toString().equals(sb2.toString());
    }

    public void traverseTree(TreeNode root, StringBuilder sb) {
        if (root != null) {
            traverseTree(root.left, sb);
            if (root.left == null && root.right == null) {
                sb.append(root.val + ",");
            }
            traverseTree(root.right, sb);
        }
    }
}
// @lc code=end

