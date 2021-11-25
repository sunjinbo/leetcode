/*
 * @lc app=leetcode.cn id=590 lang=java
 *
 * [590] N 叉树的后序遍历
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, ans);
        return ans;
    }

    public void dfs(Node node, List<Integer> ans) {
        if (node != null) {
            if (node.children != null) {
                for (int i = 0; i < node.children.size(); ++i) {
                    dfs(node.children.get(i), ans);
                }
            }
            ans.add(node.val);
        }
    }
}
// @lc code=end

