import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=832 lang=java
 *
 * [832] 翻转图像
 */

// @lc code=start
class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        for (int i = 0; i < image.length; ++i) {
            int[] row = image[i];
            int l = 0, r = row.length - 1;
            while (l < r) {
                if (row[l] == row[r]) {
                    row[l] ^= 1;
                    row[r] ^= 1;
                }

                ++l;
                --r;
            }

            if (l == r) {
                row[l] ^= 1;
            }
        }

        return image;
    }
}
// @lc code=end

