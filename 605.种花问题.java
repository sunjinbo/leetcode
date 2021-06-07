/*
 * @lc app=leetcode.cn id=605 lang=java
 *
 * [605] 种花问题
 */

// @lc code=start
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for (int i = 0; i < flowerbed.length; ++i) {
            boolean left = false;
            boolean right = false;
            if (i - 1 >= 0 && flowerbed[i - 1] == 1) {
                left = true;
            }

            if (i + 1 <  flowerbed.length && flowerbed[i + 1] == 1) {
                right = true;
            }

            if (!left && !right && flowerbed[i] == 0) {
                flowerbed[i] = 1;
                count++;
            }
        }

        return count >= n;
    }
}
// @lc code=end

