/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || (s != null && s.length() <= 1)) return s;

        int resultStart = 0;
        int resultEnd = 0;
        for (int start = 0; start < s.length(); ++start) {
            for (int end = s.length() - 1; (end > start) && (end - start > resultEnd - resultStart); --end) {
                int tempStart = start;
                int tempEnd = end;
                boolean isPalindrome = true;
                while (tempStart < tempEnd) {
                    if (s.charAt(tempStart) == s.charAt(tempEnd)) {
                        ++tempStart;
                        --tempEnd;
                        continue;
                    } else {
                        isPalindrome = false;
                        break;
                    }
                }

                if (isPalindrome) {
                    if (end - start > resultEnd - resultStart) {
                        resultStart = start;
                        resultEnd = end;
                    }
                }
            }
        }

        if (resultEnd > resultStart) {
            return s.substring(resultStart, resultEnd + 1);
        } else {
            return s.length() > 0 ? s.substring(0, 1) : "";
        }
    }
}
// @lc code=end

