/*
 * @lc app=leetcode.cn id=8 lang=java
 *
 * [8] 字符串转换整数 (atoi)
 */

// @lc code=start
class Solution {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) return 0;

        int sign = 1;
        String s = "";
        int state = 0; // 0表示start状态，1代表sign状态，2表示number状态，3表示end状态

        for (int i = 0; i < str.length(); ++i) {
            char ch = str.charAt(i);
            switch (state) {
                case 0: // start
                    if (ch == ' ') {
                        continue;
                    } else if (isDigit(ch)) {
                        state = 2;
                        s += ch;
                    } else if (isSign(ch)) {
                        state = 1;
                        sign = (ch == '+') ? 1 : -1;
                    } else {
                        state = 3;
                    }
                    break;
                case 1: // sign
                    if (isDigit(ch)) {
                        state = 2;
                        s += ch;
                    } else {
                        state = 3;
                    }
                    break;
                case 2: // number
                    if (isDigit(ch)) {
                        s += ch;
                    } else {
                        state = 3;
                    }
                    break;
                case 3: // end
                    break;
                default:
                    break;
            }
        }

        if (s.length() == 0) return 0;

        int ans = 0;
        for (int i = 0; i < s.length(); ++i) {
            int b = s.charAt(i) - '0';
            if (ans > (Integer.MAX_VALUE - b) / 10) {
                return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            } else {
                ans = 10 * ans + b;
            }
        }

        return ans * sign;
    }

    public boolean isSign(char ch) {
        return ch == '+' || ch == '-';
    }

    public boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }
}
// @lc code=end

