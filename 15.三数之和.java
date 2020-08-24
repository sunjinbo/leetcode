import java.util.HashMap;
import java.util.List;

/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) return result;

        Arrays.sort(nums); // 先对整个整型数组做从小到大的排序

        for (int i = 0; i < nums.length - 2; ++i) {
            if (nums[i] > 0) break; // // 第一个数大于 0，后面的数都比它大，肯定不成立了
            if (i > 0 && nums[i] == nums[i-1]) continue; // 去掉重复情况

            int target = -nums[i];

            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    result.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));

                    left++;
                    right--;

                    while (left < right && nums[left] == nums[left - 1]) left++; // 去掉重复情况
                    while (left < right && nums[right] == nums[right + 1]) right--; // 去掉重复情况
                } else if (nums[left] + nums[right] < target) {
                    // 和偏小，需要增大nums[left]同nums[right]的和
                    left++;
                } else {
                    // 和偏大，需要减少nums[left]同nums[right]的和
                    right--;
                }
            }
        }

        return result;
    }
}
// @lc code=end

