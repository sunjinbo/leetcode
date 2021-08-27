/*
 * @lc app=leetcode.cn id=1909 lang=java
 *
 * [1909] 删除一个元素使数组严格递增
 */

// @lc code=start
class Solution {
    public boolean canBeIncreasing(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            boolean isIncreasing = true;
            for (int j = 0; j < nums.length; ++j) {
                if (i != j) {
                    if (j - 1 >= 0) {
                        if (j - 1 == i) {
                            if (j - 2 >= 0 && nums[j - 2] >= nums[j]) {
                                isIncreasing = false;
                                break;
                            }
                        } else {
                            if (nums[j - 1] >= nums[j]) {
                                isIncreasing = false;
                                break;
                            }
                        }
                    }
                }
            }
            if (isIncreasing) {
                return true;
            }
        }
        return false;
    }
}
// @lc code=end

