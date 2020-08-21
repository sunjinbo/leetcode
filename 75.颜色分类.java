/*
 * @lc app=leetcode.cn id=75 lang=java
 *
 * [75] 颜色分类
 */

// @lc code=start
class Solution {
    public void sortColors(int[] nums) {
        
        int p0 = 0;
        int p2 = nums.length - 1;
        int cur = p0;

        int temp;
        while (cur <= p2) {
            if (nums[cur] == 0) {
                temp = nums[p0];
                nums[p0] = nums[cur];
                nums[cur] = temp;
                p0 += 1;
                cur += 1;
            } else if (nums[cur] == 2) {
                temp = nums[p2];
                nums[p2] = nums[cur];
                nums[cur] = temp;
                p2 -= 1;
            } else {
                cur += 1;
            }
        }
    }
}
// @lc code=end

