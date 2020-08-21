import java.awt.List;

/*
 * @lc app=leetcode.cn id=91 lang=java
 *
 * [91] 解码方法
 */

// @lc code=start
class Solution {
    public int numDecodings(String s) {
        List<Integer> leaf = new ArrayList<>();
        
        for (int i = 0; i < s.length(); ++i) {
            int integer = Integer.parseInt(s.charAt(i) + "");
            if (i == 0 && integer > 0) {
                leaf.add(integer);
            } else {
                for (int j = leaf.size() - 1; j >= 0; --j) {
                    int n = leaf.get(j);
                    if (integer == 0) {
                        if (n == 1 || n == 2) {
                            leaf.set(j, n * 10 + integer);
                        } else {
                            leaf.remove(j);
                        }
                    } else {
                        if (n == 1 || (n == 2 && integer <= 6)) {
                            leaf.set(j, n * 10 + integer);
                            leaf.add(integer);
                        } else {
                            leaf.set(j, integer);
                        }
                    }
                }
            }
        }
        
        return leaf.size();
    }
}
// @lc code=end

