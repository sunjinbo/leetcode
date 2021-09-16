/*
 * @lc app=leetcode.cn id=905 lang=java
 *
 * [905] 按奇偶排序数组
 */

// @lc code=start
class Solution {
    public int[] sortArrayByParity(int[] nums) {
        for (int i = 0; i < nums.length - 1; ++i) {
            for (int j = 0; j < nums.length - 1 - i; ++j) {
                if (nums[j] % 2 == 1 && nums[j + 1] % 2 == 0) {
                    int t = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = t;
                }
            }
        }
        return nums;
    }
}
// @lc code=end

