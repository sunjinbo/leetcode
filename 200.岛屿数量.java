import sun.security.util.Length;

/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 */

// @lc code=start
class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null 
        || grid.length == 0 
        || grid[0].length == 0) return 0;

        int row = grid.length;
        int column = grid[0].length;

        int island = 0;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < column; ++j) {
                if (grid[i][j] == '1') {
                    island += 1;
                    dfs(grid, row, column, i, j);
                }
            }
        }
        return island;
    }

    public void dfs(char[][] grid, int r, int c, int x, int y) {
        grid[x][y] = '0';
        if (x - 1 >= 0 && grid[x-1][y] == '1') dfs(grid, r, c, x - 1, y);
        if (x + 1 < r && grid[x+1][y] == '1') dfs(grid, r, c, x + 1, y);
        if (y - 1 >= 0 && grid[x][y-1] == '1') dfs(grid, r, c, x, y - 1);
        if (y + 1 < c && grid[x][y+1] == '1') dfs(grid, r, c, x, y + 1);
    }
}
// @lc code=end

