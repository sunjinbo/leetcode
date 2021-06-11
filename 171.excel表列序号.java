/*
 * @lc app=leetcode.cn id=171 lang=java
 *
 * [171] Excel表列序号
 */

// @lc code=start
class Solution {
    public int titleToNumber(String columnTitle) {
        int sum = 0;
        int digit = 0;
        for (int i = columnTitle.length() - 1; i >= 0; --i) {
            int number = columnTitle.charAt(i) - 'A' + 1;
            sum += getNumber(number, digit++);
        }
        return sum;
    }

    private int getNumber(int number, int digit) {
        int sum = 1;
        for (int i = 0; i < digit; ++i) {
            sum *= 26;
        }
        return number * sum;
    }
}
// @lc code=end

