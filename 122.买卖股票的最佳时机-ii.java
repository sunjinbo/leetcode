/*
 * @lc app=leetcode.cn id=122 lang=java
 *
 * [122] 买卖股票的最佳时机 II
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int totalMax = 0;
        int max = 0;
        int[] dp = new int[prices.length];
        dp[0] = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] <= prices[i - 1]) {
                totalMax += max;
                // 重置状态
                dp[i] = prices[i];
                max = 0;
            } else {
                dp[i] = Math.min(dp[i - 1], prices[i]);
                max = Math.max(max, prices[i] - dp[i]);
            }
        }

        totalMax += max;

        return totalMax;
    }
}
// @lc code=end

