/*
 * @lc app=leetcode.cn id=136 lang=java
 *
 * [136] 只出现一次的数字
 */

// @lc code=start
class Solution {
    public int singleNumber(int[] nums) {
        int num = 0;
        for (int i = 0; i < nums.length; ++i) {
            num ^= nums[i];
        }
        return num;
    }
}
// @lc code=end

