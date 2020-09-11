/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[] {-1, -1};
        if (nums == null || nums.length == 0) {
            return ans;
        }

        int index = binarySearch(nums, target);
        if (index == -1) {
            return ans;
        }

        ans[0] = index;
        ans[1] = index;
        while (ans[0] - 1 >= 0 && nums[ans[0] - 1] == target) {
            ans[0] -= 1;
        }

        while (ans[1] + 1 < nums.length && nums[ans[1] + 1] == target) {
            ans[1] += 1;
        }

        return ans;
    }

    public int binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
    
        while ((low <= high) && (low <= nums.length - 1)
                && (high <= nums.length - 1)) {
            int middle = (high + low) >> 1;
            if (target == nums[middle]) {
                return middle;
            } else if (target < nums[middle]) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return -1;
    }
}
// @lc code=end

