/*
 * @lc app=leetcode.cn id=695 lang=java
 *
 * [695] 岛屿的最大面积
 */

// @lc code=start
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 1) {
                    int area = traverseIslandArea(i, j , grid);
                    if (area > maxArea) {
                        maxArea = area;
                    }
                }
            }
        }

        return maxArea;
    }

    public int traverseIslandArea(int x, int y, int[][] grid) {
        int area = 1;
        
        grid[x][y] = 2; // 遍历过，将数值改为2

        if (y - 1 >= 0 && grid[x][y - 1] == 1) { // 向左
            area += traverseIslandArea(x, y - 1, grid);
        }

        if (y + 1 < grid[0].length && grid[x][y + 1] == 1) { // 向右
            area += traverseIslandArea(x, y + 1, grid);
        }

        if (x - 1 >= 0 && grid[x - 1][y] == 1) { // 向上
            area += traverseIslandArea(x - 1, y, grid);
        }

        if (x + 1 < grid.length && grid[x + 1][y] == 1) { // 向下
            area += traverseIslandArea(x + 1, y, grid);
        }

        return area;
    }
}
// @lc code=end

