/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        int maxShape = 0;
        for (int i = 0; i < height.length; ++i) {
            for (int j = i + 1; j < height.length; ++j) {
                int shape = Math.min(height[i], height[j]) * (j - i);
                if (shape > maxShape) {
                    maxShape = shape;
                }
            }
        }
        return maxShape;
    }
}
// @lc code=end

