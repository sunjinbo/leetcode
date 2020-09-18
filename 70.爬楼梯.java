/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {
        // 首先排除给定量n的特殊值
        if (n < 3) {
            return n;
        }

        // 定义DP标记列表
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;

        // for循环遍历给定n项数值，
        // 利用状态转移公式得到相应的DP标记列表
        for (int i = 3; i <= n; ++i) {
            // 状态转移公式
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
}
// @lc code=end

