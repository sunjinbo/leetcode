/*
 * @lc app=leetcode.cn id=485 lang=java
 *
 * [485] 最大连续 1 的个数
 */

// @lc code=start
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int count = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 1) {
                count += 1;
            } else {
                if (maxCount < count) {
                    maxCount = count;
                }
                count = 0;
            }
        }

        return maxCount < count ? count : maxCount;
    }
}
// @lc code=end

