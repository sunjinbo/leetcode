/*
 * @lc app=leetcode.cn id=168 lang=java
 *
 * [168] Excel表列名称
 */

// @lc code=start
class Solution {
    public String convertToTitle(int columnNumber) {
        int n = columnNumber;
        char[] chart = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y','Z'};
        String s = "";
        while (n > 0) {
            int a = (n-1)%26;
            char tem = chart[a];
            s = tem + s;
            n = n - 1;
            n = n / 26;
        }
        return s;
    }
}
// @lc code=end

