/*
 * @lc app=leetcode.cn id=35 lang=java
 *
 * [35] 搜索插入位置
 */

// @lc code=start
class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) 
            return 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length; // 插入到最后
    }
}
// @lc code=end

