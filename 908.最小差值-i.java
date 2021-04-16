/*
 * @lc app=leetcode.cn id=908 lang=java
 *
 * [908] 最小差值 I
 */

// @lc code=start
class Solution {
    public int smallestRangeI(int[] A, int K) {
        if (A.length == 1) return 0;
        Arrays.sort(A);
        int diff = (A[A.length - 1] - K) - (A[0] + K);
        return diff > 0 ? diff : 0;
    }
}
// @lc code=end

