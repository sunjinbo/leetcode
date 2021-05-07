/*
 * @lc app=leetcode.cn id=349 lang=java
 *
 * [349] 两个数组的交集
 */

// @lc code=start
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> collection = new ArrayList();

        for (int i = 0; i < nums1.length; i++) {
            if (!collection.contains(nums1[i])) {
                // 查看是否在数组num2中
                for (int j = 0; j < nums2.length; j++) {
                    if (nums1[i] == nums2[j]) {
                        collection.add(nums1[i]);
                        break;
                    }
                }
            }
        }

        return collection.stream().mapToInt(Integer::valueOf).toArray();
    }
}
// @lc code=end

