/*
 * @lc app=leetcode.cn id=962 lang=java
 *
 * [962] 最大宽度坡
 */

// @lc code=start
class Solution {
    public int maxWidthRamp(int[] nums) {
        int maxWidthRamp = 0;
        for (int i = 0; i < nums.length; ++i) {
            for (int j = nums.length - 1; j > 0; --j) {
                if (j - i > maxWidthRamp) {
                    if (nums[i] <= nums[j]) {
                        maxWidthRamp = j - i;
                    }
                } else {
                    break;
                }
            }
        }
        return maxWidthRamp;
    }
}
// @lc code=end

