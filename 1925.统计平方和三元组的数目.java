/*
 * @lc app=leetcode.cn id=1925 lang=java
 *
 * [1925] 统计平方和三元组的数目
 */

// @lc code=start
class Solution {
    public int countTriples(int n) {
        int count = 0;
        for (int c = n; c >= 1; --c) {
            for (int b = n - 1; b >= 1; --b) {
                for (int a = n - 1; a >= 1; --a) {
                    if (a * a + b * b == c * c) {
                        ++count;
                    }
                }
            }
        }
        return count;
    }
}
// @lc code=end

