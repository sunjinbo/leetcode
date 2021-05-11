/*
 * @lc app=leetcode.cn id=121 lang=java
 *
 * [121] 买卖股票的最佳时机
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int[] dp = new int[prices.length];
        dp[0] = prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i] = (dp[i - 1] < prices[i]) ? dp[i - 1] : prices[i];
            max = (prices[i] - dp[i]) > max ? prices[i] - dp[i] : max;
        }
        return max;
    }
}
// @lc code=end

