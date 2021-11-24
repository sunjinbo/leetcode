import java.util.List;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=637 lang=java
 *
 * [637] 二叉树的层平均值
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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList();

        List<TreeNode> layer = new ArrayList();
        layer.add(root);

        while (true) {
            // 判断当前层是否还有节点
            if (layer.isEmpty()) break;

            // 计算均值
            Double sum = 0.0;
            for (int i = 0; i < layer.size(); ++i) {
                sum += Double.parseDouble(layer.get(i).val + "");
            }
            ans.add(sum / layer.size());

            // 获取下一层的节点
            List<TreeNode> nextLayer = new ArrayList();
            for (int i = 0; i < layer.size(); ++i) {
                if (layer.get(i).left != null) {
                    nextLayer.add(layer.get(i).left);
                }
                
                if (layer.get(i).right != null) {
                    nextLayer.add(layer.get(i).right);
                }
            }

            //  更新layer
            layer.clear();
            layer.addAll(nextLayer);
        }

        return ans;
    }
}
// @lc code=end

