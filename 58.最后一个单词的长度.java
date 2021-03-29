/*
 * @lc app=leetcode.cn id=58 lang=java
 *
 * [58] 最后一个单词的长度
 */

// @lc code=start
class Solution {
    public int lengthOfLastWord(String s) {
        int num = 0;

        if (s == null || s.length() == 0) return num;

        boolean spaceTail = false;
        for (int i = s.length() - 1; i >= 0; --i) {
            if (s.charAt(i) == ' ') {
                if (spaceTail) {
                    break;
                } else {
                    continue;
                }
            } else {
                num += 1;
                spaceTail = true;
            }
        }

        return num;
    }
}
// @lc code=end

