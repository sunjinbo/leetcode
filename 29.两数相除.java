/*
 * @lc app=leetcode.cn id=29 lang=java
 *
 * [29] 两数相除
 */

// @lc code=start
class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == 0) return 0;
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE; 
        if (divisor == 0) throw new IllegalArgumentException();

        final int k = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)
            ? -1 : 1;

        int quotient = 0; // 商
        int cumulate = 0; // 临时积

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        while (true) {
            cumulate += divisor;
            if (cumulate <= dividend) {
                quotient += 1;
            } else {
                break;
            }
        }
        return quotient * k;
    }
}
// @lc code=end

