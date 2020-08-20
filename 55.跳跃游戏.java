/*
 * @lc app=leetcode.cn id=55 lang=java
 *
 * [55] 跳跃游戏
 */

// @lc code=start
class Solution {
    public boolean canJump(int[] nums) {
        if (nums[0] == 0 && nums.length == 1) return true;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 0) {
                boolean isLastZero = (i == nums.length - 1);
                int k = isLastZero ? 1 : 0; // 如果零在最后一位，可以少跳1步
                int canJumpCount = 0;
                for (int j = i - 1; j >= 0; --j) {
                    if (nums[j] > i - j - k) {
                        canJumpCount += 1;
                    }
                }
                if (canJumpCount == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
// @lc code=end

