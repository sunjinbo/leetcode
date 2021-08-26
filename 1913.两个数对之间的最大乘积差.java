import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1913 lang=java
 *
 * [1913] 两个数对之间的最大乘积差
 */

// @lc code=start
class Solution {
    public int maxProductDifference(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        return nums[len - 1] * nums[len - 2] - nums[0] * nums[1];
    }
}
// @lc code=end

