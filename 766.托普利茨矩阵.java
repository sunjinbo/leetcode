/*
 * @lc app=leetcode.cn id=766 lang=java
 *
 * [766] 托普利茨矩阵
 */

// @lc code=start
class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int height = matrix.length;
        int width = matrix[0].length;

        for (int i = 0; i < width; ++i) {
            for (int j = 0; j < height; ++j) {
                if (i == 0 || j == 0) {
                    if (!isNumberSame(matrix, i, j)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean isNumberSame(int[][] matrix, int startX, int startY) {
        int height = matrix.length;
        int width = matrix[0].length;

        int last = -1;
        while (startX >= 0 && startX < width && startY >= 0 && startY < height) {
            if (last == -1) {
                last = matrix[startY][startX];
            } else {
                if (last != matrix[startY][startX]) {
                    return false;
                }
            }
            startX++;
            startY++;
        }

        return true;
    }
}
// @lc code=end

