/*
 * @lc app=leetcode.cn id=28 lang=java
 *
 * [28] 实现 strStr()
 */

// @lc code=start
class Solution {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) return 0;
        if (haystack.length() < needle.length()) return -1;

        for (int i = 0; i < haystack.length(); ++i) {
            boolean find = true;
            for (int j = 0; j < needle.length(); ++j) {
                if (i + j >= haystack.length() 
                || haystack.charAt(i + j) != needle.charAt(j)) {
                    find = false;
                    break;
                }
            }

            if (find) {
                return i;
            }
        }

        return -1;
    }
}
// @lc code=end

