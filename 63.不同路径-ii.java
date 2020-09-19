/*
 * @lc app=leetcode.cn id=63 lang=java
 *
 * [63] 不同路径 II
 */

// @lc code=start
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // 首先排除给定量n的特殊值
        if (obstacleGrid == null 
        || obstacleGrid.length == 0 
        || obstacleGrid[0].length == 0) {
            return 0;
        }

        // 定义DP标记列矩阵
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        boolean columnObstacled = false;
        boolean rowObstacled = false;

        // for循环遍历给定n项数值，
        // 利用状态转移公式得到相应的DP标记列表
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                    if (i == 0) columnObstacled = true;
                    if (j == 0) rowObstacled = true;
                } else {
                    if (i - 1 < 0 ) {
                        // 判断第一列上元素，之前如果没有遇到障碍物的话，路径数为1
                        // 否则障碍物之后的元素的路径数为0
                        dp[i][j] = columnObstacled ? 0 : 1;
                    } else if (j - 1 < 0) {
                        // 判断第一行上元素，之前如果没有遇到障碍物的话，路径数为1
                        // 否则障碍物之后的元素的路径数为0
                        dp[i][j] = rowObstacled ? 0 : 1;
                    } else {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                    }
                }
            }
        }

        return dp[m-1][n-1];
    }
}
// @lc code=end

