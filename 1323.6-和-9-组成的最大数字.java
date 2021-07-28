/*
 * @lc app=leetcode.cn id=1323 lang=java
 *
 * [1323] 6 和 9 组成的最大数字
 */

// @lc code=start
class Solution {
    public int maximum69Number (int num) {
        String numString = Integer.toString(num);
        StringBuilder strBuilder = new StringBuilder(numString);
        for (int i = 0; i < numString.length(); ++i) {
            if (numString.charAt(i) == '6') {
                strBuilder.setCharAt(i, '9');
                break;
            }
        }
        return Integer.parseInt(strBuilder.toString());
    }
}
// @lc code=end

