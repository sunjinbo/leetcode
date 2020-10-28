/*
 * @lc app=leetcode.cn id=88 lang=java
 *
 * [88] 合并两个有序数组
 */

// @lc code=start
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int nums1_max_index = m - 1;
        int nums2_max_index = n - 1;
        int pending_index = m + n  - 1;

        while (pending_index >= 0) {
            if (nums1_max_index >= 0 && nums2_max_index >= 0) {
                if (nums1[nums1_max_index] >= nums2[nums2_max_index]) {
                    // 应该将nums1数组队尾的数, 移动到相应位置
                    nums1[pending_index] = nums1[nums1_max_index];
                    nums1_max_index -= 1;
                } else {
                    // 应该将nums2数组队尾的数, 移动到相应位置
                    nums1[pending_index] = nums2[nums2_max_index];
                    nums2_max_index -= 1;
                }
                pending_index -= 1;
            } else if (nums1_max_index >= 0) {
                // nums2数组中数已经排完，nums1数组剩余的数不需要再排了
                break;
            } else {
                // nums1数组中数已经排完，将nums2数组剩余的数排到nums1数组中
                nums1[pending_index] = nums2[nums2_max_index];
                nums2_max_index -= 1;
                pending_index -= 1;
            }
        }
    }
}
// @lc code=end

