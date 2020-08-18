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

        dividend = -Math.abs(dividend);
        divisor = -Math.abs(divisor);

        // 采用二分法的思想，dividend每次减去2^n个divisor（尽可能多），
        // 同时reslut每次加2^n
        while (dividend <= divisor) {
			int cumulate = divisor;
			int c = 1;
			while(dividend - cumulate <= cumulate) {
				cumulate = cumulate << 1;
				c = c << 1;
            }
            
			dividend -= cumulate;
			quotient += c;
		}

        return quotient * k;
    }
}
// @lc code=end

