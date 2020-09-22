/*
 * @lc app=leetcode.cn id=62 lang=java
 *
 * [62] 不同路径
 */

// @lc code=start
class Solution {
    public int uniquePaths(int m, int n) {
        // 首先排除给定量n的特殊值
        if (m == 0 || n == 0) {
            return 0;
        }

        // 定义DP标记列矩阵
        int[][] dp = new int[m][n];

        // for循环遍历给定n项数值，
        // 利用状态转移公式得到相应的DP标记列表
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[m-1][n-1];
    }
}
// @lc code=end

