/*
 * @lc app=leetcode.cn id=1929 lang=java
 *
 * [1929] 数组串联
 */

// @lc code=start
class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] ans = new int[nums.length * 2];
        for (int i = 0; i < ans.length; ++i) {
            ans[i] = nums[i % nums.length];
        }
        return ans;
    }
}
// @lc code=end

