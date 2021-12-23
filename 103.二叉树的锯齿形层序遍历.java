import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=103 lang=java
 *
 * [103] 二叉树的锯齿形层序遍历
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(root, ans, 1);
        return ans;
    }

    public void dfs(TreeNode node, List<List<Integer>> ans, int level) {
        if (node != null) {
            if (ans.size() < level) {
                List<Integer> newLevel = new ArrayList<Integer>();
                ans.add(newLevel);
            }

            List<Integer> curList = ans.get(level - 1);
            
            if ((level % 2) == 1) {
                curList.add(node.val);
            } else {
                curList.add(0, node.val);
            }

            dfs(node.left, ans, level + 1);
            dfs(node.right, ans, level + 1);
        }
    }
}
// @lc code=end

