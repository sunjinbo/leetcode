/*
 * @lc app=leetcode.cn id=482 lang=java
 *
 * [482] 密钥格式化
 */

// @lc code=start
class Solution {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();

        int kk = 0;
        for (int i = s.length() - 1; i >= 0; --i) {
            char ch = s.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                ch = (char) ((ch - 'a') + 'A');
            } else if (ch == '-') {
                continue;
            } else {
                // ignore
            }

            if (kk >= k) {
                kk = 0;
                sb.insert(0, '-');
            }

            sb.insert(0, ch);
            kk += 1;
        }

        return sb.toString();
    }
}
// @lc code=end

