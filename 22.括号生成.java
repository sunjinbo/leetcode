import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 */

// @lc code=start
class Solution {
    public List<String> generateParenthesis(int n) {
        return generate(n);
    }

    public ArrayList<String> generate(int n) {
        ArrayList<String> arr = new ArrayList<>();
        if (n == 0) {
            arr.add("");
        } else {
            for (int i = 0; i <= n - 1; ++i) {
                int ln = i;
                int rn = n - 1 - ln;
                for (String leftStr : generate(ln)) {
                    for (String rightStr : generate(rn)) {
                        arr.add("(" + leftStr + ")" + rightStr);
                    }
                }
            }
        }
        return arr;
    }
}
// @lc code=end

