/*
 * @lc app=leetcode.cn id=235 lang=java
 *
 * [235] 二叉搜索树的最近公共祖先
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pPath = new ArrayList();
        List<TreeNode> qPath = new ArrayList();

        findPath(root, p, pPath);
        findPath(root, q, qPath);

        TreeNode ancestor = root;
        int len = Math.min(pPath.size(), qPath.size());
        for (int i = 0; i < len; ++i) {
            if (pPath.get(i).val == qPath.get(i).val) {
                ancestor = pPath.get(i);
            } else {
                break;
            }
        }

        return ancestor;
    }

    public void findPath(TreeNode current, TreeNode p, List<TreeNode> path) {
        path.add(current);
        if (current.val > p.val) {
            findPath(current.left, p, path);
        } else if (current.val < p.val) {
            findPath(current.right, p, path);
        }
    }
}
// @lc code=end

