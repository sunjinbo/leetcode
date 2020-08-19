import java.util.List;

/*
 * @lc app=leetcode.cn id=6 lang=java
 *
 * [6] Z 字形变换
 */

// @lc code=start
class Solution {
    public String convert(String s, int numRows) {
        List<String>[] arr = new ArrayList[numRows];
        for (int i = 0; i < numRows; ++i) {
            arr[i] = new ArrayList<>();
        }

        boolean down = true;
        int n = 0;

        for (int c = 0; c < s.length(); ++c) {
            arr[n].add(s.charAt(c) + "");

            n = down ? n + 1 : n - 1;
            if (n >= numRows - 1) {
                n = numRows - 1;
                down = false;
            } else if (n <= 0) {
                n = 0;
                down = true;
            }
        }

        String ret = "";
        for (int i = 0; i < numRows; ++i) {
            List<String> lst = arr[i];
            for (int j = 0; j < lst.size(); ++j) {
                ret += lst.get(j);
            }
        }
        return ret;
    }
}
// @lc code=end

