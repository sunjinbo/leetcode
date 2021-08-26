/*
 * @lc app=leetcode.cn id=1920 lang=java
 *
 * [1920] 基于排列构建数组
 */

// @lc code=start
class Solution {
    public int[] buildArray(int[] nums) {
        int[] ans = new int[nums.length];

        for (int i = 0; i < ans.length; ++i) {
            ans[i] = nums[nums[i]];
        }

        return ans;
    }
}
// @lc code=end

