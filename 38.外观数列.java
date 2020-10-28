/*
 * @lc app=leetcode.cn id=38 lang=java
 *
 * [38] 外观数列
 */

// @lc code=start
class Solution {
    public String countAndSay(int n) {
        if (n <= 0 || n > 30) return "";

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; ++i) {
            if (sb.toString().length() == 0) {
                sb.append(i);
            } else {
                String progression = sb.toString();
                sb.setLength(0);
                int current_digit = char2Int(progression.charAt(0));
                int count = 0;
                for (int j = 0; j < progression.length(); ++j) {
                    int digit = char2Int(progression.charAt(j));
                    if (current_digit == digit) {
                        count += 1;
                    } else {
                        sb.append(count);
                        sb.append(current_digit);

                        current_digit = digit;
                        count = 1;
                    }
                }
                if (count > 0) {
                    sb.append(count);
                    sb.append(current_digit);
                }
            }
        }

        return sb.toString();
    }

    public int char2Int(char ch) {
        return (int)(ch) - (int)('0');
    }
}
// @lc code=end

