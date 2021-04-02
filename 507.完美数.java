/*
 * @lc app=leetcode.cn id=507 lang=java
 *
 * [507] 完美数
 */

// @lc code=start
class Solution {
    public boolean checkPerfectNumber(int num) {
        int totalSum = 0;
        int middle = num / 2;
        for (int i = 1; i <= middle; ++i) {
            if (num % i == 0) {
                totalSum += i;
            }
        }
        return (totalSum == num);
    }
}
// @lc code=end

