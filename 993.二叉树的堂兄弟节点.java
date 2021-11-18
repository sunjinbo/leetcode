/*
 * @lc app=leetcode.cn id=993 lang=java
 *
 * [993] 二叉树的堂兄弟节点
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
    public boolean isCousins(TreeNode root, int x, int y) {
        SupperTreeNode xNode = getTreeNode(root, x);
        SupperTreeNode yNode = getTreeNode(root, y);

        if (xNode != null && xNode != null ) {
            if (xNode.k == yNode.k && xNode.parent.node != yNode.parent.node) {
                return true;
            }
        }

        return false;
    }

    public SupperTreeNode getTreeNode(TreeNode root, int val) {
        if (root != null) {
            return dfs(null, root, val);
        }
        return null;
    }

    public SupperTreeNode dfs(SupperTreeNode parent, TreeNode node, int val) {
        SupperTreeNode supperNode = new SupperTreeNode(parent, node);
        if (supperNode.node.val == val) {
            return supperNode;
        }

        if (node.left != null) {
            SupperTreeNode sn = dfs(supperNode, node.left, val);
            if (sn != null) return sn;
        }

        if (node.right != null) {
            SupperTreeNode sn = dfs(supperNode, node.right, val);
            if (sn != null) return sn;
        }

        return null;
    }

    class SupperTreeNode {
        public SupperTreeNode parent;
        public TreeNode node;
        public int k = 0;

        public SupperTreeNode(SupperTreeNode parent, TreeNode node) {
            this.parent = parent;
            this.node = node;
            if (parent != null) {
                k = parent.k + 1;
            }
        }
    }
}
// @lc code=end

