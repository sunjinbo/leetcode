import java.awt.List;

/*
 * @lc app=leetcode.cn id=91 lang=java
 *
 * [91] 解码方法
 */

// @lc code=start
class Solution {
    public int numDecodings(String s) {
        if (s.startsWith("0")) return 0;

        Node head = new Node();
        List<Node> leafs = new ArrayList<>();

        for (int i = 0; i < s.length(); ++i) {
            int val = Integer.parseInt(s.charAt(i) + "");
            if (leafs.size() == 0) {
                if (val > 0) {
                    leafs.add(new Node(head, val));
                }
            } else {
                List<Node> temp = new ArrayList<>();

                for (int j = 0; j < leafs.size(); ++j) {
                    Node leaf = leafs.get(j);

                    if (val > 0) {
                        Node newLeaf = new Node(leaf, val);
                        temp.add(newLeaf);
                    }

                    if ((leaf.val == 1 && val <= 9) || (leaf.val == 2 && val <= 6)) {
                        if (leaf.parent != null) {
                            Node newLeaf2 = new Node(leaf.parent, leaf.val * 10 + val);
                            temp.add(newLeaf2);
                        }
                    }
                }

                if (temp.size() > 0) {
                    leafs.clear();
                    leafs.addAll(temp);
                } else {
                    return 0; // 出现异常数字，直接返回0
                }
            }
        }
        return leafs.size();
    }

    public class Node {
        public List<Node> next = new ArrayList<>();
        public Node parent = null;
        public int val;

        public Node(Node p, int v) {
            parent = p;
            val = v;
            parent.next.add(this);
        }

        public Node() {
            parent = null;
            val = -1;
        }
    }
}
// @lc code=end

