/*
 * @lc app=leetcode.cn id=1576 lang=java
 *
 * [1576] 替换所有的问号
 */

// @lc code=start
class Solution {
    public String modifyString(String s) {
        StringBuilder sb = new StringBuilder();
        char lastChar = 'z';
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (ch != '?') {
                lastChar = ch;
            } else {
                if (i < s.length() - 1) {
                    lastChar = getChar(lastChar, s.charAt(i + 1));
                } else {
                    lastChar = getChar(lastChar);
                }
            }
            sb.append(lastChar);
        }
        return sb.toString();
    }

    char getChar(char lastChar) {
        char ch = 'a';
        for (int i = 0; i < 26; ++i) {
            ch = (char) ('a' + i);
            if (lastChar != ch) {
                return ch;
            }
        }
        return ch;
    }

    char getChar(char lastChar, char nextChar) {
        char ch = 'a';
        for (int i = 0; i < 26; ++i) {
            ch = (char) ('a' + i);
            if (lastChar != ch && ch != nextChar) {
                return ch;
            }
        }
        return ch;
    }
}
// @lc code=end

