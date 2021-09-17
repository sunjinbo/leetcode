import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=779 lang=java
 *
 * [779] 第K个语法符号
 */

// @lc code=start
class Solution {
    public int kthGrammar(int n, int k) {
        /*
        int len = Math.min(k, (int)Math.pow(2, n));
        int[] arr = new int[len];
        for (int i = 1; i < n; ++i) {
            int start = (int)Math.pow(2, i - 1);
            for (int j = 0; j < start; ++j) {
                if (start + j < arr.length) {
                    arr[start + j] = arr[j] == 0 ? 1 : 0;
                }
            }
        }
        return arr[k - 1];
        */
        return Integer.bitCount(k - 1) % 2;
    }
}
// @lc code=end

