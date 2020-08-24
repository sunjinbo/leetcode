import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=16 lang=java
 *
 * [16] 最接近的三数之和
 */

// @lc code=start
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minDiff = -10000;
        int minSum = 0;
        for (int i = 0; i < nums.length - 2; ++i) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                int diff = target - sum;
                if (Math.abs(diff) < Math.abs(minDiff)) {
                    minDiff = diff;
                    minSum = sum;
                }
                if (diff == 0) {
                    return sum;
                } else if (diff > 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return minSum;
    }
}
// @lc code=end

