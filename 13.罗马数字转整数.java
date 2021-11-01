/*
 * @lc app=leetcode.cn id=13 lang=java
 *
 * [13] 罗马数字转整数
 */

// @lc code=start
class Solution {
    public int romanToInt(String s) {
        int totalRomanNum = 0;

        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            int romanNum = getNumByRomanChar(ch);
            switch (ch) {
                case 'I': // 1
                case 'X': // 10
                case 'C': // 100
                    if (i + 1 < s.length()) {
                        int nextRomanNum = getNumByRomanChar(s.charAt(i + 1));
                        if (nextRomanNum > romanNum) {
                            romanNum = nextRomanNum - romanNum;
                            i = i + 1;
                        }
                    }
                    totalRomanNum += romanNum;
                    break;

                default:
                    totalRomanNum += romanNum;
                    break;
            }
        }

        return totalRomanNum;
    }
 
    int getNumByRomanChar(char ch) {
        switch (ch) {
            case 'I': return 1; // 1
            case 'V': return 5; // 5
            case 'X': return 10; // 10
            case 'L': return 50; // 50
            case 'C': return 100; // 100
            case 'D': return 500; // 500
            case 'M': return 1000; // 1000
        }
        return 0;
    }
}
// @lc code=end

