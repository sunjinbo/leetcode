import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=199 lang=java
 *
 * [199] 二叉树的右视图
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
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> ans = new ArrayList();

        if (root == null) return ans;
        
        // 用于存放广度优先搜索遍历的节点
        Queue<TreeNodeExt> bfsQueue = new LinkedBlockingDeque<>();
        bfsQueue.add(new TreeNodeExt(root, 1));

        TreeNodeExt last = new TreeNodeExt(null, 0);
        while (!bfsQueue.isEmpty()) {
            TreeNodeExt node = bfsQueue.poll();
            if (node.getLeft() != null) {
                bfsQueue.add(new TreeNodeExt(node.getLeft(), node.deep + 1));
            }

            if (node.getRight() != null) {
                bfsQueue.add(new TreeNodeExt(node.getRight(), node.deep + 1));
            }

            if (last.deep > 0 && last.deep != node.deep) {
                ans.add(last.node.val);
            }

            last = node;
        }

        if (last.deep > 0) {
            ans.add(last.node.val);
        }
        
        return ans;
    }

    class TreeNodeExt {
        public TreeNode node;
        public int deep;

        public TreeNodeExt(TreeNode node, int deep) {
            this.node = node;
            this.deep = deep;
        }

        public TreeNode getLeft() {
            return node.left;
        }

        public TreeNode getRight() {
            return node.right;
        }
    }
}
// @lc code=end

