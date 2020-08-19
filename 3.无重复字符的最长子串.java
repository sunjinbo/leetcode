/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null) return 0;
        int max = 0;
        String temp = "";
        for (int i = 0; i < s.length(); ++i) {
            temp = "";
            for (int j = i; j < s.length(); ++j) {
                if (temp.contains(s.charAt(j) + "")) {
                    break;
                } else {
                    temp += s.charAt(j);
                }
            }
            if (max < temp.length()) {
                max = temp.length();
            }
        }
        return max;
    }
}
// @lc code=end

