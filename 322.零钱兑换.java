/*
 * @lc app=leetcode.cn id=322 lang=java
 *
 * [322] 零钱兑换
 */

// @lc code=start
class Solution {
    public int coinChange(int[] coins, int amount) {
        // dp[i] 为组合成 i 时需要的最少硬币数
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i < amount + 1; ++i) {
            dp[i] = amount + 1;
        }

        for (int i = 1; i <= amount; ++i) {
            for (int j = 0; j < coins.length; ++j) {
                // 当前硬币的大小
                int coin = coins[j];
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] >= amount + 1 ? -1 : dp[amount];
    }
}
// @lc code=end

