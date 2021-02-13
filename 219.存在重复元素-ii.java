/*
 * @lc app=leetcode.cn id=219 lang=java
 *
 * [219] 存在重复元素 II
 */

// @lc code=start
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // 遍历数组，对于每个元素做以下操作：
        // a. 在散列表中搜索当前元素，如果找到了就返回 true。
        // b. 在散列表中插入当前元素。
        // c. 如果当前散列表的大小超过了 kk， 删除散列表中最旧的元素。
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}
// @lc code=end

