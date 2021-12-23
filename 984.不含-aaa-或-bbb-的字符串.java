/*
 * @lc app=leetcode.cn id=984 lang=java
 *
 * [984] 不含 AAA 或 BBB 的字符串
 */

// @lc code=start
class Solution {
    public String strWithout3a3b(int A, int B) {
        StringBuilder sb = new StringBuilder();

        while (A > 0 && B > 0) {
            if (A > B) {
                sb.append("aab");
                A -= 2;
                B -= 1;
            } else if (B == A) {
                sb.append("ab");
                A -= 1;
                B -= 1;
            } else {
                sb.append("bba");
                A -= 1;
                B -= 2;
            }
        }

        while (A > 0) {
            sb.append("a");
            A -= 1;
        }

        while (B > 0) {
            sb.append("b");
            B -= 1;
        }

        return sb.toString();
    }
}
// @lc code=end

