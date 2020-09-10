/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除排序数组中的重复项
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        int current = -1;
        for (int i = 0; i < nums.length; ++i) {
            if (current == -1) {
                current = i;
            } else {
                if (i != current && nums[i] != nums[current]) {
                    nums[++current] = nums[i];
                }
            }
        }
        return current + 1;
    }
}
// @lc code=end

