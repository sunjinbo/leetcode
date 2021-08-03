/*
 * @lc app=leetcode.cn id=496 lang=java
 *
 * [496] 下一个更大元素 I
 */

// @lc code=start
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] results = new int[nums1.length];

        for (int i = 0; i < nums1.length; ++i) {
            int element = -1;
            boolean startFind = false;
            for (int j = 0; j < nums2.length; ++j) {
                if (nums1[i] == nums2[j]) {
                    startFind = true;
                }

                if (startFind && nums1[i] < nums2[j]) {
                    element = nums2[j];
                    break;
                }
            }

            results[i] = element;
        }

        return results;
    }
}
// @lc code=end

