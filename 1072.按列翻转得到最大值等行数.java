/*
 * @lc app=leetcode.cn id=1072 lang=java
 *
 * [1072] 按列翻转得到最大值等行数
 */

// @lc code=start
class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int ans = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int cnt = 0;
        for (int i = 0; i < matrix.length; i ++) {
            int[] flip = new int[n];
            int cur = 0;
            for (int j = 0; j < n; j ++) flip[j] = 1 - matrix[i][j];
            for (int k = i; k < m; k ++) {
                if (Arrays.equals(matrix[k], matrix[i]) || Arrays.equals(matrix[k], flip)) {
                    cur ++;
                }
            }
            cnt = Math.max(cur, cnt);
        }
        return cnt;
    }
}
// @lc code=end

