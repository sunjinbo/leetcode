import java.awt.List;

/*
 * @lc app=leetcode.cn id=91 lang=java
 *
 * [91] 解码方法
 */

// @lc code=start
class Solution {
    public int numDecodings(String s) {
        // 首先排除给定字符串的特殊情况
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        // 定义DP标记列表
        int[] dp = new int[s.length() + 2];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;
        
        // for循环遍历给定n项数值，
        // 利用状态转移公式得到相应的DP标记列表
        for (int i = 1; i < s.length(); ++i) {
            // 解码方法的状态转移公式略显复杂
            int n = i + 2;
            if (s.charAt(i) == '0') {
                if (s.charAt(i-1) == '1' || s.charAt(i-1) == '2') {
                    dp[n] = dp[n-2];
                } else {
                    return 0;
                }
            } else if (s.charAt(i-1) == '1' 
            || (s.charAt(i-1) == '2' && (s.charAt(i) >= '1' && s.charAt(i) <= '6'))) {
                dp[n] = dp[n-1] + dp[n-2];
            } else {
                dp[n] = dp[n-1];
            }
        }

        return dp[s.length()+1];
    }
}
// @lc code=end

